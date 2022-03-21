package com.example.prohappymultiplatform.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton

class FinalizeSessionFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var finishSessionButton: MaterialButton


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_finalize_session, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        finishSessionButton = view.findViewById(R.id.finish_session)
        finishSessionButton.setOnClickListener {
            navigate(NavigationAction.MessageDone.name)
        }
    }

    override fun onStop() {
        super.onStop()
    }
}
