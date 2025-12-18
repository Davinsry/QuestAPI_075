package com.example.localrestapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.localrestapi.modeldata.DetailSiswa
import com.example.localrestapi.modeldata.UIStateSiswa
import com.example.localrestapi.modeldata.toSiswa
import com.example.localrestapi.repositori.RepositoryDataSiswa
import retrofit2.Response

class EntryViewModel (private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel() {
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    // Fungsi untuk memvalidasi input
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telepon.isNotBlank()
        }
    }

    // Fungsi untuk menangani saat ada perubahan pada text input
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    // Fungsi untuk menyimpan data siswa
    suspend fun addSiswa() {
        if (validasiInput()){
            val sip: Response<Void> = repositoryDataSiswa.postDataSiswa(uiStateSiswa.detailSiswa.toSiswa())
            if (sip.isSuccessful){
                println("Sukses bro : ${sip.message()}")
            }else{
                println("Gagal bro : ${sip.errorBody()}")
            }
        }
    }
}
