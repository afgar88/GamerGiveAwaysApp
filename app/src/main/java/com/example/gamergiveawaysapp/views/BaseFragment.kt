package com.example.gamergiveawaysapp.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gamergiveawaysapp.R
import com.example.gamergiveawaysapp.adapter.GiveawayAdapter
import com.example.gamergiveawaysapp.viewmodel.GiveawaysViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

open class BaseFragment : Fragment() {
    protected val giveawaysViewModel: GiveawaysViewModel by sharedViewModel()

    protected val giveawaysAdapter by lazy {
        GiveawayAdapter {
            giveawaysViewModel.selectedCurrentGiveAway=it
            findNavController().navigate(
                R.id.detailsFragment
            )
        }
    }
}