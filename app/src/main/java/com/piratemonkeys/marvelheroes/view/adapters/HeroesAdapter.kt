package com.piratemonkeys.marvelheroes.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.piratemonkeys.marvelheroes.R
import com.piratemonkeys.marvelheroes.core.request.dto.HeroData
import kotlinx.android.synthetic.main.hero_list_item.view.*

class HeroesAdapter:RecyclerView.Adapter<HeroesAdapter.ViewHolder>(){

    var heroes : ArrayList<HeroData> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context)
                                 .inflate(R.layout.hero_list_item, parent, false))

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroesAdapter.ViewHolder, position: Int) = holder.bind(heroes[position])

    fun addData(data: List<HeroData>) {
        this.heroes.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(hero : HeroData) = with(itemView) {
            with(hero) {
                hero_description_tv.text = description
                hero_name_tv.text = name
                //thumbnail_hero.load(thumbnail["path"]+"."+thumbnail["extension"]){request -> request.fit() }
            }
        }
    }

}
