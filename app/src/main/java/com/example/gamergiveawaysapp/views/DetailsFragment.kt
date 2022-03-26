package com.example.gamergiveawaysapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gamergiveawaysapp.R
import com.example.gamergiveawaysapp.databinding.FragmentDetailsBinding
import com.example.gamergiveawaysapp.databinding.FragmentGiveawaysBinding
import com.example.gamergiveawaysapp.model.Giveaways
import com.example.gamergiveawaysapp.viewmodel.GiveawaysViewModel
import com.squareup.picasso.Picasso


class DetailsFragment : BaseFragment() {
    private val binding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    var giveaways: Giveaways? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        giveaways = giveawaysViewModel.selectedCurrentGiveAway

        binding.title.text = giveaways?.title
        binding.descripcion.text = giveaways?.description
        binding.platforms.text = giveaways?.platforms
        binding.worth.text = giveaways?.worth
        // Inflate the layout for this fragment

        Picasso.get()
            .load(giveaways?.image)
            .fit()
            .into(binding.detailbackground)

        return binding.root
    }


}