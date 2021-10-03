package ru.kgsu.tornadotest.ui

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class MyView : View() {
    private val controller: MyController by inject()
    val input = SimpleStringProperty()

    override val root = form {
        fieldset {
            field("Input") {
                textfield(input)
            }

            button("Commit") {
                action {
                    controller.writeToDb(input.value)
                    input.value = "Sasha Koval ♥"
                }
            }
        }
    }
}


class MyController: Controller() {
    fun writeToDb(inputValue: String?) {
        println("Writing $inputValue to database!")
    }
}