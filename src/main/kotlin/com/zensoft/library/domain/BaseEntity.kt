package com.zensoft.library.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.ZonedDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AuditEntity<P : Serializable> : Serializable {

    @CreatedDate
    @Column(name = "created_at")
    var createdAt: ZonedDateTime? = null

    @LastModifiedDate
    @Column(name = "changed_at")
    var changedAt: ZonedDateTime? = null

    @CreatedBy
    @Column(name = "created_by")
    var createdBy: Long? = null

    @LastModifiedBy
    @Column(name = "changed_by")
    var changedBy: Long? = null

    abstract fun getPId(): P?
    abstract fun setPId(id: P?)
}

@MappedSuperclass
abstract class BaseEntity : AuditEntity<Long>() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Transient
    val className: String = this.javaClass.simpleName

    @JsonIgnore
    override fun getPId(): Long? = id

    override fun setPId(id: Long?) {
        this.id = id
    }

    @JsonIgnore
    fun isPersisted(): Boolean {
        val tempId = id
        return null != tempId && 0 < tempId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result *= 31
        return result
    }
}