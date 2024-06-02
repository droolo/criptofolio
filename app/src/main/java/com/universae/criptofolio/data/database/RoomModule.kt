package com.universae.criptofolio.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val CRIPTO_DATABASE_NAME = "criptofolio2"
    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context,
            CriptofolioDatabase::class.java, CRIPTO_DATABASE_NAME).build()


    @Provides
    @Singleton
    fun provideDao(db:CriptofolioDatabase) = db.getCriptofolioDao()
}