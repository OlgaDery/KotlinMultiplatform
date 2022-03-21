package com.example.prohappymultiplatform.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

class HomeFragment : BaseFragment() {

    lateinit var homeViewModel: HomeViewModel
    private lateinit var startSesssionButton: com.google.android.material.button.MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_home1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)

        startSesssionButton = view.findViewById(R.id.start_session_button)
        startSesssionButton.tag = NavigationAction.StartSession.name
        startSesssionButton.setOnClickListener {
            navigate(it.tag.toString())
        }
    }

}