package com.example.localrestapi.modeldata

@Serializable
data class DataSiswa(
    val id : Int,
    val nama : string,
    val alamat : String,
    val telpon : String
)

data class UiStatteSiswa(
    val detailSiswa: DataSiswa = DataSiswa(),
    val isEntryValid: Boolean = false
