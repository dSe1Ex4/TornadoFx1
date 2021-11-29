package ru.kgsu.tornadofx_quiz.model

import java.time.LocalDate
import java.time.Period

data class EntityObj(val id: Int, val name: String, val birthday: LocalDate){
    val age: Int get() = Period.between(birthday, LocalDate.now()).years
    val isDone: Boolean = (age >= 0)
}
