package com.zdzisiek.booker.usecase

import javax.inject.Inject
import javax.inject.Singleton

interface MainWindowPresenter {

    fun showMainWindow()

}

@Singleton
class StartApplication @Inject constructor(
    val mainWindow : MainWindowPresenter
){

    fun start(){
        mainWindow.showMainWindow()
    }
}