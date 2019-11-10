package com.zensoft.library.domain

import org.hibernate.annotations.SelectBeforeUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.Table

@Entity
@Table(name = "book")
@SelectBeforeUpdate
class Book(
    @Column(name = "name")
    var name: String,

    @Lob
    @Column(name = "content")
    var content: ByteArray,

    @Column(name = "page_count")
    var pageCount: Int,

    @Column(name = "isbn")
    var isbn:
): BaseEntity()