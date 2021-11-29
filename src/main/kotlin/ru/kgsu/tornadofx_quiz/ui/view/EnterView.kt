package ru.kgsu.tornadofx_quiz.ui.view

import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class EnterView : View() {

    override val root = stackpane {

        prefWidth = 380.0
        prefHeight = 280.0

        alignment = Pos.CENTER

        imageview("img.jpg") {
            useMaxHeight = true
            useMaxWidth = true
        }

        vbox {
            alignment = Pos.CENTER
            spacing = 8.0

            combobox<String> {
                minWidth = 150.0
                items = FXCollections.observableArrayList("1 Уровень", "2 Уровень")
            }
            button("Настройка вопросов"){
                minHeight = 50.0
                minWidth = 100.0
                style {
                    fontWeight = FontWeight.EXTRA_BOLD
                    fontSize = 20.px
                }
                action {
                    replaceWith(CreateQuestionView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
                    currentStage?.apply {
                        width = 320.0
                        height = 480.0
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
                    replaceWith(TestView::class, ViewTransition.Slide(0.8.seconds, ViewTransition.Direction.LEFT))
                    currentStage?.apply {
                        width = 380.0
                        height = 360.0
                    }
                }

                gridpaneConstraints {
                    marginTop = 10.0
                    columnSpan = 2
                }
            }
        }
    }
}
