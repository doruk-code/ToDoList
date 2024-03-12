package com.example.todolist.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.data.entity.Yapilacaklar

@Dao
interface YapilacakDao {
    @Query("SELECT * FROM todolist")
    suspend fun kisileriYukle() : List<Yapilacaklar>

    @Insert
    suspend fun kaydet(kisi:Yapilacaklar)

    @Update
    suspend fun guncelle(kisi:Yapilacaklar)

    @Delete
    suspend fun sil(kisi:Yapilacaklar)

    @Query("SELECT * FROM todolist WHERE todo_text LIKE '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar>
}