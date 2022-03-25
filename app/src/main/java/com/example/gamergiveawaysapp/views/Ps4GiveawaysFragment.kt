package com.example.gamergiveawaysapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamergiveawaysapp.R
import com.example.gamergiveawaysapp.adapter.GiveawayAdapter
import com.example.gamergiveawaysapp.databinding.FragmentPCGiveawaysBinding
import com.example.gamergiveawaysapp.databinding.FragmentPs4GiveawaysBinding
import com.example.gamergiveawaysapp.model.Giveaways
import com.example.gamergiveawaysapp.utils.GiveawayState


class Ps4GiveawaysFragment : BaseFragment() {

    private val binding by lazy {
        FragmentPs4GiveawaysBinding.inflate(layoutInflater)
    }

    private val giveawayAdapter by lazy {
        GiveawayAdapter(clickDetail = ::detailGiveaway)
    }

    private fun detailGiveaway(giveaways: Giveaways) {
        findNavController().navigate(
            R.id.action_PS4Giveaways_to_detailsFragment,
            Bundle().apply {
                putParcelable("detail", giveaways)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding.p4GiveawaysRv.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = giveawaysAdapter
        }

        giveawaysViewModel.giveaways.observe(viewLifecycleOwner) { state ->
            when (state) {
                is GiveawayState.LOADING -> {
                    Toast.makeText(requireContext(), "loading...", Toast.LENGTH_LONG).show()
                }
                is GiveawayState.SUCCESS<*> -> {
                    val giveaways = state.giveaways as List<Giveaways>
                    giveawaysAdapter.setNewGiveaways(giveaways)
                }
                is GiveawayState.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        state.error.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        giveawaysViewModel.getGiveawaysByPlatform()

        return binding.root
    }
}