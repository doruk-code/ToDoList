package com.example.todolist.data.repo

import com.example.todolist.data.datasource.YapilacakDataSource
import com.example.todolist.data.entity.Yapilacaklar

class YapilacaklarRepository(var yplc :YapilacakDataSource) {

    suspend fun kaydet(todo_text:String) = yplc.kaydet(todo_text)

    suspend fun guncelle(todo_id:Int,todo_text:String) = yplc.guncelle(todo_id, todo_text)

    suspend fun sil(todo_id:Int) = yplc.sil(todo_id)

    suspend fun listeYukle() : List<Yapilacaklar> = yplc.listeYukle()

    suspend fun ara(aramaKelimesi: String): List<Yapilacaklar> = yplc.ara(aramaKelimesi)
}