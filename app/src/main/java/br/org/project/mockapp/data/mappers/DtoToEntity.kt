package br.org.project.mockapp.data.mappers

import br.org.project.mockapp.data.model.PersonDTO
import br.org.project.mockapp.domain.model.PersonEntity

fun PersonDTO.toEntity() : PersonEntity =
    PersonEntity(this.name,this.idade.toString())


fun List<PersonDTO>.toEntity() : List<PersonEntity> =
    this.map { it.toEntity() }
