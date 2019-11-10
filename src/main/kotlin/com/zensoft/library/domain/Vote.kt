package com.zensoft.library.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "vote")
class Vote(
    @Column(name = "value")
    var value: String,

    @Column(name = "book_id")

) : BaseEntity()