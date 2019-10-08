package com.zdzisiek.booker.ui

import com.zdzisiek.booker.usecase.MainWindowPresenter
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.stage.Stage


class MainApplicationWindow : Application(), MainWindowPresenter {

    override fun start(stage: Stage?) {
        val pane = HBox(Button("Hello!"))
        val scene = Scene(pane, 1400.0, 900.0)
        stage?.scene = scene
        stage?.show()
    }

    override fun showMainWindow() {
        launch()
    }
}