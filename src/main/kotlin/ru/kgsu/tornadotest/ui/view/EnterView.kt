package view

import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class EnterView : View() {

    override val root = stackpane {

        prefWidth = 640.0
        prefHeight = 480.0

        alignment = Pos.CENTER

        imageview("img.jpg") {
            useMaxHeight = true
            useMaxWidth = true
        }

        button("Войти") {
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                fontSize = 20.px
                rotate = 25.deg
                borderColor += box(
                    top = Color.RED,
                    right = Color.DARKGREEN,
                    left = Color.ORANGE,
                    bottom = Color.PURPLE
                )
            }
            minHeight = 100.0
            minWidth = 150.0
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
