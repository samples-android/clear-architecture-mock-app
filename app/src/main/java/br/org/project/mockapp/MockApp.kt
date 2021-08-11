package br.org.project.mockapp

import android.app.Application
import br.org.project.mockapp.data.di.dataModule
import br.org.project.mockapp.domain.di.domainModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import presentationModule

class MockApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MockApp)
            modules(
                listOf(
                    presentationModule,
                    domainModules,
                    dataModule
                )
            )
        }
    }
}