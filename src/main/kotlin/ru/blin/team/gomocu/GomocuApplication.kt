package ru.blin.team.gomocu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GomocuApplication

fun main(args: Array<String>) {
    runApplication<GomocuApplication>(*args)
}
