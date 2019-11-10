package com.zensoft.library.domain

import javax.persistence.*

@Entity
@Table(name = "genre")
class Genre(
        @Column(name = "name")
        var name: String,

        @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
        var books: List<Book>
): BaseEntity()