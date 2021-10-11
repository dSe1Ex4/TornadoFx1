package ru.kgsu.tornadofx_quiz.ui.view

import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*

class RestoreView : View() {
    override val root = gridpane {

        prefWidth = 320.0
        prefHeight = 240.0

        alignment = Pos.CENTER

        row {
            label("Восстановить доступ") {
                font = Font(30.0)
                style = "-fx-font-weight: bold"

                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
            }
        }

        row {
            hbox {
                label("Введите email ") {
                    font = Font(20.0)
                }

                textfield {
                    useMaxWidth = true
                }

                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
            }
        }

        row {
            button("Отправить письмо") {
                useMaxWidth = true
                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }

            }
        }

        row {
            hbox {
                label("Код из письма ") {
                    font = Font(20.0)
                }

                textfield {
                    useMaxWidth = true
                }

                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
            }
        }

        row {
            hbox{
                label("Новый пароль ") {
                    font = Font(20.0)
                }

                passwordfield {
                    useMaxWidth = true
                }

                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
            }
        }

        row {
            button("Подтвердить") {
                useMaxWidth = true
                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }

                action {
                    replaceWith<LoginView>()
                    currentStage?.apply {
                        width = 320.0
                        height = 280.0
                    }
                }
            }
        }
    }
}