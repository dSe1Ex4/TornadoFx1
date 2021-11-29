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

        vbox {
            radiobutton("Один правильный ответ", toggleGroup).isSelected = true
            radiobutton("Несколько правильных ответов", toggleGroup)
            radiobutton("Соответствия", toggleGroup)
            radiobutton("Текстовый ответ", toggleGroup)
            maxWidth = 200.0
        }

        imageview("radiobatton.png") {
            isPreserveRatio = false
            fitHeight = 200.0
            fitWidth = 250.0
        }

        val tf = textfield {
            isVisible = false
            minWidth = 150.0
        }

        toggleGroup.selectedToggleProperty().addListener(ChangeListener { observable, oldValue, newValue ->
            val rb = (newValue as RadioButton)

            tf.isVisible = (rb.text == "Текстовый ответ")
        })

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
            style{
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
