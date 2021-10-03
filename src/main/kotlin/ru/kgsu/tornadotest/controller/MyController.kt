package controller

import tornadofx.Controller

class MyController: Controller() {

    fun writeToDb(inputValue: String) {
        println("$inputValue")
    }

}