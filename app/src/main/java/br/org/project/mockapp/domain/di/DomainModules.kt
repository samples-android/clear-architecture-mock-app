package br.org.project.mockapp.domain.di

import br.org.project.mockapp.domain.usecases.GetPersonsMockedUseCase
import br.org.project.mockapp.domain.usecases.GetPersonsUseCase
import br.org.project.mockapp.domain.usecases.IGetMockedUseCase
import br.org.project.mockapp.domain.usecases.IGetPersonsUseCase
import org.koin.core.scope.get
import org.koin.dsl.module

val domainModules = module {
    factory<IGetMockedUseCase> { GetPersonsMockedUseCase(get()) }
    factory<IGetPersonsUseCase> { GetPersonsUseCase(get()) }
}