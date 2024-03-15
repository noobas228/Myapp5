package com.example.myapplication2

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication2.network.CharacterData

class DiffUtillCallBack : DiffUtil.ItemCallback<CharacterData>(){
    override fun areItemsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CharacterData, newItem: CharacterData): Boolean {
        return oldItem.name == newItem.name && oldItem.species == newItem.species
    }


}