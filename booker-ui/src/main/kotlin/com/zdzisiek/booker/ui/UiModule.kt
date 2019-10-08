package com.zdzisiek.booker.ui

import com.zdzisiek.booker.usecase.MainWindowPresenter
import dev.misfitlabs.kotlinguice4.KotlinModule

class UiModule : KotlinModule() {

    override fun configure() {
        bind<MainWindowPresenter>().to<MainApplicationWindow>().asEagerSingleton()
    }

}
