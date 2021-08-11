package br.org.project.mockapp.data.datasource

import br.org.project.mockapp.data.model.PersonDTO
import retrofit2.Response

import retrofit2.http.GET

interface MockyDataSource {
    
    @GET("36078572-a82b-43d2-bf29-3d99e56a0f0f")
    suspend fun fetchPersons(): Response<List<PersonDTO>>
}