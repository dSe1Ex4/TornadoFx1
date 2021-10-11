package ru.kgsu.tornadofx_quiz.ui.view

import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*

class RegistrationView : View() {
    override val root = gridpane {

        prefWidth = 320.0
        prefHeight = 240.0

        alignment = Pos.CENTER

        row {
            label("Регистрация") {
                font = Font(30.0)
                style = "-fx-font-weight: bold"

                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
            }
        }

        row {
            hbox(25) {
                label("Фамилия ") {
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
            hbox(75) {
                label("Имя") {
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
            hbox(60) {
                label("Логин") {
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
            hbox(47) {
                label("Пароль") {
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
            hbox(70) {
                label("Email") {
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
            button("Зарегистрироваться") {
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