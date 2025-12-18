package com.example.localrestapi.apiservice

import com.example.localrestapi.modeldata.DataSiswa
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApiSiswa {
    @GET("bacateman.php") // <-- GANTI JADI HURUF KECIL SEMUA
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php") // Pastikan file insertTM.php di htdocs hurufnya juga sama persis
    suspend fun postSiswa(@Body dataSiswa: DataSiswa):retrofit2.Response<Void>
}