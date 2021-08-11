package br.org.project.mockapp.data.repository

import br.org.project.mockapp.data.datasource.MockyDataSource
import br.org.project.mockapp.data.mappers.toEntity
import br.org.project.mockapp.domain.model.PersonEntity
import br.org.project.mockapp.domain.repositories.IPersonRepository
import br.org.project.mockapp.domain.utils.Result

class PersonRepository(private val dataSource: MockyDataSource) : IPersonRepository {
    override suspend fun fetchPersons(): Result<List<PersonEntity>> =
        try {
            Result.Success(dataSource.fetchPersons().body()?.toEntity() ?: listOf())
        } catch (e: Exception) {
            Result.Error(Exception())
        }
}