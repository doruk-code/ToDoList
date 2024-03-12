package com.example.todolist.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs

import com.example.todolist.databinding.FragmentDetayBinding

import com.example.todolist.ui.viewmodel.ListeDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListeDetayFragment : Fragment() {

    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: ListeDetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle : ListeDetayFragmentArgs by navArgs()
        val gelenListe = bundle.liste

        binding.editTextListeText.setText(gelenListe.todo_text)

        binding.buttonGuncelle.setOnClickListener {
            val todo_text = binding.editTextListeText.text.toString()
            guncelle(gelenListe.todo_id,todo_text)
        }

        return binding.root
    }

    fun guncelle(todo_id:Int, todo_text:String){
        viewModel.guncelle(todo_id, todo_text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: ListeDetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}