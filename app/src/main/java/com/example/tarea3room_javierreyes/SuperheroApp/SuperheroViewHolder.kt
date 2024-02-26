package com.example.tarea3room_javierreyes.SuperheroApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea3room_javierreyes.database.entities.ListEntity
import com.example.tarea3room_javierreyes.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItemResponse: ListEntity, navigateToDetailActivity: (String) -> Unit) {
        binding.tvSuperheroName.text = superheroItemResponse.name
        Picasso.get().load(superheroItemResponse.image).into(binding.ivSuperhero)
        binding.root.setOnClickListener {
            navigateToDetailActivity(superheroItemResponse.id.toString())
        }
    }
}
