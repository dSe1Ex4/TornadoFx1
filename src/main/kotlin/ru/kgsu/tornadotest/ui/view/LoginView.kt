package view

import javafx.geometry.Pos
import javafx.scene.text.Font
import tornadofx.*

class LoginView : View() {

    override val root = gridpane {

        prefWidth = 320.0
        prefHeight = 240.0

        alignment = Pos.CENTER

        row {
            label("Вход") {
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
                label("Login") {
                    font = Font(18.0)
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
            hbox(20) {
                label("Password") {
                    font = Font(18.0)
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
            button("Войти") {
                useMaxWidth = true
                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
            }
        }

        row {
            button("Зарегистрироваться") {
                useMaxWidth = true
                action {
                    replaceWith<RegistrationView>()
                    currentStage?.height = 320.0
                }

                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
            }
        }

        row {
            button("Восстановить доступ") {
                useMaxWidth = true
                gridpaneConstraints {
                    marginBottom = 10.0
                    columnSpan = 2
                }
                action {
                    replaceWith<RestoreView>()
                    currentStage?.apply {
                        width = 420.0
                        height = 320.0
                    }
                }
            }

        }
    }

}