package com.example.localrestapi.repositori

import okhttp3.logging.HttpLoggingInterceptor

interface ContainerApp{
    val repositorySiswa: RepositoryDataSiswa
}

class DefaultAppContainer: ContainerApp{
    private val baseurl = "http://10.0.2.2/umyti/"

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
class DefaultContaienrApp : ContainerApp {

    private val baseurl = "http://10.0.2.2/umyti/"

}

}
