package com.example.gamergiveawaysapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamergiveawaysapp.databinding.GiveawayItemBinding
import com.example.gamergiveawaysapp.model.Giveaways
import com.squareup.picasso.Picasso

class GiveawayAdapter(
    private val giveaways: MutableList<Giveaways> = mutableListOf(),
    private val clickDetail: (giveaways: Giveaways) -> Unit
) : RecyclerView.Adapter<GiveAwayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GiveAwayViewHolder {
        val view = GiveawayItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GiveAwayViewHolder(view, clickDetail)


    }

    override fun onBindViewHolder(holder: GiveAwayViewHolder, position: Int) =
        holder.bind(giveaways[position])

    override fun getItemCount(): Int = giveaways.size

    fun setNewGiveaways(newGiveaways: List<Giveaways>) {
        giveaways.clear()
        giveaways.addAll(newGiveaways)
        notifyDataSetChanged()
    }
}

class GiveAwayViewHolder(
    private val binding: GiveawayItemBinding,
    private val clickDetail: (giveaways: Giveaways) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(giveaways: Giveaways) {
        binding.giveawayDate.text = giveaways.endDate
        binding.giveawayPlatform.text = giveaways.platforms
        binding.giveawayTitle.text = giveaways.title
        binding.giveawayWorth.text = giveaways.worth
        binding.giveawayStatus.text = giveaways.status
        binding.root.setOnClickListener{clickDetail(giveaways)}

        Picasso.get()
            .load(giveaways.image)
            .into(binding.giveawayImage)
    }

}