package br.org.project.mockapp.domain.usecases

import br.org.project.mockapp.domain.model.PersonEntity
import br.org.project.mockapp.domain.repositories.IPersonRepository
import br.org.project.mockapp.domain.utils.Result


interface IGetPersonsUseCase{
    suspend operator fun  invoke() : List<PersonEntity>
}


class GetPersonsUseCase(private val repo : IPersonRepository) : IGetPersonsUseCase{
    override suspend fun invoke(): List<PersonEntity> {
        return when(val result = repo.fetchPersons()){
            is Result.Success -> result.data
            is Result.Error -> listOf()
        }
    }
}

class GetPersonsMockedUseCase(private val repo : IPersonRepository) : IGetMockedUseCase{
    override suspend fun invoke(): List<PersonEntity>  = listOf(
        PersonEntity("JB","666"),
        PersonEntity("Lulinha","13")
    )
}

interface IGetMockedUseCase {

    suspend operator fun invoke(): List<PersonEntity>
}
