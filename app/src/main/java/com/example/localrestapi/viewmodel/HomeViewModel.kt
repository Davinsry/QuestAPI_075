package com.example.localrestapi.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localrestapi.modeldata.DataSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import kotlinx.coroutines.launch
import okio.IOException

sealed interface StatusUiSiwa{
    data class Success(val listSiswa: List<DataSiswa>) : StatusUiSiwa
    object Error : StatusUiSiwa
    object Loading : StatusUiSiwa
}


class HomeViewModel(private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel(){
    var listSiswa: StatusUiSiwa by mutableStateOf(StatusUiSiwa.Loading)
        private set

    init{
        loadSiswa()
    }

    fun loadSiswa(){
        viewModelScope.launch {
            listSiswa = StatusUiSiwa.Loading
            listSiswa = try{
                StatusUiSiwa.Success(repositoryDataSiswa.getSiswa())
            }catch (e: IOException){
                StatusUiSiwa.Error
            }

}