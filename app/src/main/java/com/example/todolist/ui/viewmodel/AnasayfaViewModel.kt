package com.example.todolist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.todolist.data.entity.Yapilacaklar
import com.example.todolist.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(val krepo : YapilacaklarRepository) : ViewModel() {

    var todoListesi = MutableLiveData<List<Yapilacaklar>>()

    init {
        listeYukle()
    }

    fun sil(todo_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            krepo.sil(todo_id)
            listeYukle()
        }
    }

    fun listeYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            todoListesi.value = krepo.listeYukle()
        }
    }
    fun ara(aramaKelimesi:String) {
        CoroutineScope(Dispatchers.Main).launch {
            todoListesi.value = krepo.ara(aramaKelimesi)
        }
    }
}
