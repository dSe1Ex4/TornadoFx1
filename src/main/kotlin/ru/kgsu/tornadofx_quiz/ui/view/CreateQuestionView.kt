package ru.kgsu.tornadofx_quiz.ui.view

import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.control.RadioButton
import javafx.scene.control.Toggle
import javafx.scene.control.ToggleGroup
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*
import javax.swing.event.ChangeListener

class CreateQuestionView : View() {

    private val toggleGroup = ToggleGroup()

    override val root = vbox {
        alignment = Pos.CENTER
        spacing = 4.0

        toggleGroup.selectedToggleProperty().addListener(ChangeListener { observable, oldValue, newValue ->
            if ((newValue as RadioButton).text == "Текстовый ответ"){

            }
        })

        vbox {
            radiobutton("Один правильный ответ", toggleGroup).isSelected = true
            radiobutton("Несколько правильных ответов", toggleGroup)
            radiobutton("Соответствия", toggleGroup)
            radiobutton("Текстовый ответ", toggleGroup)
        }

        textfield {
            isVisible = false
            minWidth = 150.0
        }
        button("Настройка вопросов"){
            minHeight = 50.0
            minWidth = 100.0
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                fontSize = 20.px
            }
            action {
                replaceWith<LoginView>()
                currentStage?.apply {
                    width = 320.0
                    height = 280.0
                }
            }
        }
        spacer {
            setMaxSize(30.0, 30.0)
        }
        button("Тестирование") {
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                fontSize = 20.px
                rotate = 0.deg
                borderColor += box(
                    top = Color.RED,
                    right = Color.DARKGREEN,
                    left = Color.ORANGE,
                    bottom = Color.PURPLE
                )
            }
            minHeight = 50.0
            minWidth = 80.0
            action {
                replaceWith<LoginView>()
                currentStage?.apply {
                    width = 320.0
                    height = 280.0
                }
            }

            gridpaneConstraints {
                marginTop = 10.0
                columnSpan = 2
            }
        }
    }
}
