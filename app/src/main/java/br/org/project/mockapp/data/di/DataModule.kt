package br.org.project.mockapp.data.di

import br.org.project.mockapp.BuildConfig
import br.org.project.mockapp.data.datasource.MockyDataSource
import br.org.project.mockapp.data.repository.PersonRepository
import br.org.project.mockapp.domain.repositories.IPersonRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    fun getLogInterceptor() : OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BASIC })
        .build()

    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getLogInterceptor())
            .build()
    }

    fun getMockyDataSource() : MockyDataSource {
        return getRetrofit().create(MockyDataSource::class.java)
    }


    single<IPersonRepository> { PersonRepository(get()) }
    factory { getMockyDataSource() }

}