package com.zdzisiek.booker.ui

import com.jfoenix.controls.*
import com.zdzisiek.booker.usecase.MainWindowPresenter
import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.ToggleGroup
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.io.File
import com.jfoenix.assets.JFoenixResources

class TopPane : BorderPane(){
    init {
        left = JFXHamburger()
        center = HBox(
            JFXButton(" << "),
            JFXButton(" < "),
            JFXTextField(" 34").apply {
                alignment = Pos.CENTER
            },
            JFXButton(" >  "),
            JFXButton(" >> ")
        ).apply {
            alignment = Pos.CENTER
        }
        right = HBox(
            JFXButton("Otwórz katalog").apply {
                styleClass.add("button-raised")
            },
            JFXButton("Eksportuj").apply {
                styleClass.addAll("button-raised", "button-main")
            }
        ).apply {
            styleClass.add("button-bar")
        }
        padding = Insets(14.0)
    }
}

class SettingsPane : VBox(){
    init {
        with(children) {
            val toggle = ToggleGroup()

            add(JFXTextField("Tytuł pliku"))

            add(
                HBox(
                    JFXRadioButton("jedna strona").apply { toggleGroup = toggle },
                    JFXRadioButton("dwie strony").apply { toggleGroup = toggle; isSelected = true }
                ).apply {
                    spacing = 7.0
                }
            )

            add(Label("Rozmiar czcionki"))
            add(JFXSlider(12.0,144.0,42.0))
            add(Label("Minimalna szerokość tekstu"))
            add(JFXSlider(100.0,4444.0,800.0))
            add(JFXToggleButton().apply {
                text = "Podbij kontrast"
                isSelected = true
            })
            add(JFXToggleButton().apply {
                text = "Zaznacz rozpoznane strony"
                isSelected = true
            })
            add(JFXToggleButton().apply {
                text = "Pokaz oryginał"
                isSelected = false
            })
        }
        spacing = 14.0
        padding = Insets(14.0, 28.0,14.0,14.0)
        prefWidth = 333.0
    }
}

class ImagePreview  : BorderPane(){
    init {
        center = ImageView(Image(File("c:/data/cialo/DSC08524.JPG").toURI().toString()))
            .apply {
                fitWidth = 1000.0
                fitHeight = 700.0
            }
    }
}


class MainApplicationWindow : Application(), MainWindowPresenter {

    override fun start(stage: Stage?) {
        val pane = BorderPane().apply {
            top = TopPane()
            center = ImagePreview()
            right = SettingsPane()
        }

        val scene = Scene(pane, 1400.0, 900.0)
        scene.stylesheets.addAll(
            JFoenixResources.load("css/jfoenix-fonts.css").toExternalForm(),
            JFoenixResources.load("css/jfoenix-design.css").toExternalForm(),
            MainApplicationWindow::class.java.getResource("/booker.css").toExternalForm()
        )
        stage?.scene = scene
        stage?.show()
    }

    override fun showMainWindow() {
        launch()
    }
}