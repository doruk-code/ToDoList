package com.example.todolist.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.todolist.databinding.FragmentKayitBinding
import com.example.todolist.ui.viewmodel.ListeKayitViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListeKayitFragment : Fragment() {

    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: ListeKayitViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val todo_text = binding.editTextYapilacak.text.toString()
            kaydet(todo_text)
        }

        return binding.root
    }

    fun kaydet(todo_text:String){
        viewModel.kaydet(todo_text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:ListeKayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}