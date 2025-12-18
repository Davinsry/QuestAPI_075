package com.example.localrestapi.repositori

import com.example.localrestapi.apiservice.ServiceApiSiswa
import com.example.localrestapi.modeldata.DataSiswa

interface RepositoryDataSiswa{
    suspend fun getSiswa(): List<DataSiswa>
    suspend fun  postDatasiswa(dataSiswa: DataSiswa): retrofit2.Response<Void>
}


class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
): RepositoryDataSiswa{
    override suspend fun getDataSiswa() : List<DataSiswa> = serviceApiSiswa.getSiswa()

}
