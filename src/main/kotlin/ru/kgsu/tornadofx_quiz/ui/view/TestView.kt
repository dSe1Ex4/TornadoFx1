package ru.kgsu.tornadofx_quiz.ui.view

import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import javafx.util.Duration
import ru.kgsu.tornadofx_quiz.model.EntityObj
import tornadofx.*
import java.time.LocalDate

class TestView : View() {

    private val toggleGroup = ToggleGroup()
    private val tblObjs = listOf(
        EntityObj(1,"RadioButton",LocalDate.of(2011,12,4)),
        EntityObj(2,"Start War",LocalDate.of(2018,1,23)),
        EntityObj(3,"Start Revolution",LocalDate.of(2019,5,23)),
        EntityObj(4,"Start NWW", LocalDate.of(2045,8,11))
    ).asObservable()

    override val root = vbox {
        alignment = Pos.CENTER
        spacing = 4.0

/*        val rectangle = polyline(0.0, 80.0, 0.0, 0.0, 80.0, 40.0) {
            padding = Insets(20.0)
        }*/

        alignment = Pos.CENTER
        val star1 = svgpath("M54.84,7.28c-1,.22-2.27,1.42-3.4,3.27-1.55,2.55-2.88,5.63-6,13.94-2.6,6.9-3.65,9.34-5,11.67-1.58,2.72-2.68,3.26-6.59,3.27A73.56,73.56,0,0,1,24,38.5c-2.32-.31-5-.64-7-.85a54.71,54.71,0,0,0-6.79,0c-2.7.49-3.94,1.52-4,3.34a7.1,7.1,0,0,0,1.21,3.85c1.48,2.57,3.86,5.35,9.88,11.55,7.17,7.37,9.36,10.25,9.69,12.67.28,2-.72,5.73-3.4,12.73s-3.23,8.4-3.68,9.68c-1.89,5.33-2.64,8.71-2.39,10.79s1.09,2.9,2.68,3c2.34.18,5.77-1.48,12.75-6.15,5.63-3.76,6.65-4.43,7.89-5.2,3.39-2.09,5.39-3,6.94-3a3.56,3.56,0,0,1,2.33.73c2,1.16,4.3,3.32,9.75,9.08,7.56,8,10.55,10.52,13.15,11.13a2.39,2.39,0,0,0,1.92-.23c.77-.44,1.2-1.18,1.53-2.66a10.29,10.29,0,0,0,.17-2.75c0-1.09,0-2.33-.09-2.79-.38-3.31-.8-5.88-1.9-11.65-1.72-9-2.09-11.58-2.09-14.37a8.08,8.08,0,0,1,.41-3c.76-1.93,3.47-4.28,9.57-8.31,5-3.27,6.24-4.13,7.55-5,5.54-3.9,8-6.64,8-9,0-1.35-.72-2.38-2.3-3.29-2.25-1.31-5.61-2.06-13.24-3-7.89-.94-10-1.29-12.29-2-2.9-.88-3.85-1.76-4.86-4.5-.88-2.41-1.58-5.49-2.93-12.93-1-5.62-1.6-8.49-2.17-10.8-.87-3.47-1.8-5.83-2.86-7.19A2.59,2.59,0,0,0,54.84,7.28Z") {
            stroke = Color.DARKGREY
            strokeWidth = 1.0
            effect = DropShadow()
            scaleX = 1.5
            scaleY = 1.5
        }
        timeline {
            isAutoReverse = true
            cycleCount = 99
            keyframe(Duration.seconds(1.50)) {
                keyvalue(star1.translateXProperty(), 100 )
                keyvalue(star1.translateYProperty(), -10 )
                keyvalue(star1.rotateProperty(),90.0)
                keyvalue(star1.scaleXProperty(),1.0)
                keyvalue(star1.fillProperty(), Color.DARKRED)
            }
        }


/*        tableview(tblObjs) {
            readonlyColumn("ID",EntityObj::id)
            readonlyColumn("Goal", EntityObj::name)
            readonlyColumn("Date", EntityObj::birthday)
            readonlyColumn("Long", EntityObj::age)
            readonlyColumn("Done",EntityObj::isDone).setCellFactory {
                return@setCellFactory CustomCell()
            }
            maxHeight = 150.0
        }*/

/*        text {
            wrappingWidthProperty().set(250.0)
            text = "Решите неравенство −8x+11 < −3x−4"
        }

        vbox {
            radiobutton("x<3", toggleGroup)
            radiobutton("x>3 +", toggleGroup)
            maxWidth = 200.0
        }*/
        spacer {
            setMaxSize(30.0, 30.0)
        }
        button("Готово") {
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                fontSize = 20.px
                rotate = 0.deg
                borderColor += box(
                    top = Color.RED,
                    right = Color.ORANGE,
                    left = Color.ORANGE,
                    bottom = Color.ORANGE
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
        spacer {
            setMaxSize(30.0, 30.0)
        }
    }
}

class CustomCell : TableCell<EntityObj?, Boolean?>() {

/*    override fun updateSelected(selected: Boolean) {
        super.updateSelected(selected)
        textFill = if (item) Color.CHOCOLATE else Color.BLACK
    }*/

    override fun updateItem(item: Boolean?, empty: Boolean) {
        super.updateItem(item, empty)
        if (!empty){
            text = if (item == true) "Done" else "Process"
        }
        if (item == true) {
            textFill = Color.CHOCOLATE
        }

        if (!empty && item == false){
            background = Color.YELLOW.asBackground()
        }

/*        setOnMouseClicked {
            if (it.button == MouseButton.SECONDARY && !empty) {
                background = Color.RED.asBackground()
            }
        }*/
    }
}