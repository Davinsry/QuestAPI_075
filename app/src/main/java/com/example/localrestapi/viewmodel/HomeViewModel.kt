package com.example.localrestapi.viewmodel

import com.example.localrestapi.modeldata.DataSiswa

sealed interface StatusUiSiwa{
    data class Success(val listSiswa: List<DataSiswa>) : StatusUiSiwa
    object Error : StatusUiSiwa
    object Loading : StatusUiSiwa
}


