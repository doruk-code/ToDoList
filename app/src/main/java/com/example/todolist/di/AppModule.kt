package com.example.todolist.di

import android.content.Context
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.todolist.data.datasource.YapilacakDataSource
import com.example.todolist.data.repo.YapilacaklarRepository
import com.example.todolist.room.Veritabani
import com.example.todolist.room.YapilacakDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerRepository(yplc:YapilacakDataSource) : YapilacaklarRepository {
        return YapilacaklarRepository(yplc)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(yplc:YapilacakDao) : YapilacakDataSource  {
        return YapilacakDataSource(yplc)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : YapilacakDao {
        val vt = databaseBuilder(context, Veritabani::class.java,"todolist.sqlite")
            .createFromAsset("todolist.sqlite").build()
        return vt.getKisilerDao()
    }
}