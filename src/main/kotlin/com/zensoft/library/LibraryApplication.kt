package com.zensoft.library

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class LibraryApplication

fun main(args: Array<String>) {
	runApplication<LibraryApplication>(*args)
}
