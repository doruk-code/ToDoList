package com.example.todolist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.entity.Yapilacaklar
import com.example.todolist.data.repo.YapilacaklarRepository
import com.example.todolist.databinding.CardTasarimBinding
import com.example.todolist.ui.fragment.AnasayfaFragmentDirections
import com.example.todolist.ui.viewmodel.AnasayfaViewModel
import com.example.todolist.utils.gecis
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class YapilcakAdapter(var mContext: Context, var yapilacakListesi: List<Yapilacaklar>, var viewModel: AnasayfaViewModel)

    : RecyclerView.Adapter<YapilcakAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding): RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun getItemCount(): Int {
        return yapilacakListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val liste = yapilacakListesi.get(position)
        val t = holder.tasarim
        t.textViewTodo.text = liste.todo_text

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.listeDetayGecis(liste = liste)
            //Navigation.findNavController(it).navigate(gecis)
            Navigation.gecis(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${liste.todo_id} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.sil(liste.todo_id)
                }.show()
        }
    }
}