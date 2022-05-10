package com.example.prohappymultiplatform.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.prohappymultiplatform.Constants
import com.google.android.material.chip.Chip

class HomeFragment : BaseFragment() {

    lateinit var homeViewModel: HomeViewModel
    private lateinit var startSessionButton: com.google.android.material.button.MaterialButton
    private lateinit var startSessionChip: Chip

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        homeViewModel.initRepo(requireContext())

        startSessionButton = view.findViewById(R.id.start_session_button)
        startSessionChip = view.findViewById(R.id.start_session_chip)
        startSessionButton.apply {
            tag = NavigationAction.StartSession.name
            text = Constants.START_SESSION_BUTTON
            setOnClickListener {
                navigate(it.tag.toString())
            }
        }

        homeViewModel.numberOfSessions.observe(viewLifecycleOwner, Observer {
            startSessionChip.text = it.toString()
        })
    }

}