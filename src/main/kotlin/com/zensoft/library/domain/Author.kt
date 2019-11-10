package com.zensoft.library.domain

import org.hibernate.annotations.SelectBeforeUpdate
import java.awt.print.Book
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "author")
@SelectBeforeUpdate
class Author(
        @Column(name = "name")
        var name: String,

        @Column(name = "surname")
        var surname: String,

        @Column(name = "birthday")
        var birthday: Date,

        @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
        var books: List<Book>
): BaseEntity()