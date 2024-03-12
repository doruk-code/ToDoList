package com.example.todolist.data.datasource

import com.example.todolist.data.entity.Yapilacaklar
import com.example.todolist.room.YapilacakDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacakDataSource(var yplc: YapilacakDao) {
    suspend fun kaydet(todo_text: String) {
        val yeniYapilacak = Yapilacaklar(0, todo_text)
        yplc.kaydet(yeniYapilacak)
    }

    suspend fun guncelle(todo_id: Int, todo_text: String) {
        val guncellenenKisi = Yapilacaklar(todo_id, todo_text)
        yplc.guncelle(guncellenenKisi)
    }

    suspend fun sil(todo_id: Int) {
        val silinenKisi = Yapilacaklar(todo_id, "")
        yplc.sil(silinenKisi)
    }

    suspend fun listeYukle(): List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
            return@withContext yplc.kisileriYukle()

            /*val liste = ArrayList<Kisiler>()
            val k1 = Kisiler(1, "Ahmet", "1111")
            val k2 = Kisiler(2, "Zeynep", "2222")
            val k3 = Kisiler(3, "Beyza", "3333")
            liste.add(k1)
            liste.add(k2)
            liste.add(k3)

            return@withContext liste*/
        }

    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar> =
        withContext(Dispatchers.IO) {
            return@withContext yplc.ara(aramaKelimesi)

            /*val liste = ArrayList<Kisiler>()
            val k1 = Kisiler(1, "Ahmet", "1111")
            liste.add(k1)

            return@withContext liste*/
        }
}