package com.example.myapplication2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rikmorty.R
import com.example.myapplication2.network.CharacterData

class RecyclerViewAdapter: PagedListAdapter<CharacterData, RecyclerViewAdapter.MyViewHolder> (DiffUtillCallBack()){

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val tvnikname:TextView=view.findViewById(R.id.nikname)
        val tvspecies:TextView=view.findViewById(R.id.species)
        val tvstatuslive:TextView=view.findViewById(R.id.statuslive)
        val tvlocational:TextView=view.findViewById(R.id.locational)
        val tvoriginal:TextView=view.findViewById(R.id.original)
        val img:ImageView=view.findViewById(R.id.imageView4)



        fun bind(data: CharacterData) {
            tvnikname.text = data.name
            tvlocational.text = data.location?.name
            tvspecies.text = data.species
            tvstatuslive.text = data.status
            tvoriginal.text = data.origin?.name

            val url = data.image
            Glide.with(img)
                .load(url)
                .circleCrop()
                .into(img)
        }
    }

    //fun bind(data: CharacterData){

    //}

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycle, parent, false)
         return MyViewHolder(inflater)
    }
}