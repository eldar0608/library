package com.zensoft.library.domain

import javax.persistence.*

@Entity
@Table(name = "publisher")
class Publisher(
        @Column(name = "name")
        var name: String,

        @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
        var books: List<Book>

        ) : BaseEntity()