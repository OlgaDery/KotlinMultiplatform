package com.example.prohappymultiplatform.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.NavigationAction

class SessionExplanationFragment : BaseFragment() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var goToExerciseButton: com.google.android.material.button.MaterialButton

    val userMessage: String by lazy {
        homeViewModel.sessionRepo?.generateMessageAfterScreening() ?: "your message"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_session_explanation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToExerciseButton = view.findViewById(R.id.go_to_exercise_button)
        goToExerciseButton.setOnClickListener {
            homeViewModel.proceedToExercise()
            navigate(NavigationAction.ExplanationDone.name)
        }
    }

}
