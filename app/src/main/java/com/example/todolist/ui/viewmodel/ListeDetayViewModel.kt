package com.example.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolist.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListeDetayViewModel @Inject constructor(val krepo : YapilacaklarRepository) : ViewModel() {


    fun guncelle(todo_id:Int,todo_text:String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.guncelle(todo_id, todo_text)
        }
    }
}