package com.example.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolist.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListeKayitViewModel @Inject constructor(val krepo : YapilacaklarRepository) : ViewModel() {

    fun kaydet(todo_text:String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.kaydet(todo_text)
        }
    }
}