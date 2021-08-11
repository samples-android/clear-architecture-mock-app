package br.org.project.mockapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.project.mockapp.data.repository.PersonRepository
import br.org.project.mockapp.domain.model.PersonEntity
import br.org.project.mockapp.domain.repositories.IPersonRepository
import br.org.project.mockapp.domain.usecases.IGetMockedUseCase
import br.org.project.mockapp.domain.usecases.IGetPersonsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase : IGetPersonsUseCase,private val mocked : IGetMockedUseCase) : ViewModel() {

    private val _persons = MutableLiveData<List<PersonEntity>>()
    val persons : LiveData<List<PersonEntity>> = _persons

    fun fetchPersons() {
        viewModelScope.launch(Dispatchers.IO){
            _persons.postValue(useCase())
        }
    }

    fun fetchMockedPersons() {
        viewModelScope.launch(Dispatchers.IO){
            _persons.postValue(mocked())
        }
    }



}