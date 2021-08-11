package br.org.project.mockapp.domain.repositories

import br.org.project.mockapp.domain.model.PersonEntity
import br.org.project.mockapp.domain.utils.Result

interface IPersonRepository {

    suspend fun fetchPersons():Result<List<PersonEntity>>
}