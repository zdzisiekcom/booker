package com.zdzisiek.booker.app

import com.google.inject.Guice
import com.zdzisiek.booker.ui.MainApplicationWindow
import com.zdzisiek.booker.ui.UiModule
import com.zdzisiek.booker.usecase.MainWindowPresenter
import com.zdzisiek.booker.usecase.StartApplication
import dev.misfitlabs.kotlinguice4.KotlinModule
import dev.misfitlabs.kotlinguice4.getInstance

class RunApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Guice.createInjector(UiModule())
                .getInstance<StartApplication>()
                .start()
        }
    }

}
