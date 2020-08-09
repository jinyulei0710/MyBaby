package cn.jinyulei.mybaby.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideBabyServer(): BabyService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.103:8081/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(BabyService::class.java)
    }
}