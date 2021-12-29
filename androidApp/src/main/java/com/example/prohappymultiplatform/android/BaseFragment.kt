package com.example.prohappymultiplatform.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.testapp.NavigationAction

open class BaseFragment : Fragment() {

    fun navigate(viewTag: String) {
        Navigation.findNavController(requireActivity(), R.id.login_nav_host_fragment).apply {
            when (viewTag) {
                NavigationAction.StartSession.name -> {
                    navigate(R.id.home_fragment_to_start_session_fragment)
                }
                NavigationAction.FirstScreeningCompleted.name -> {
                    navigate(R.id.start_session_fragment_to_session_explanation_fragment)
                }
                NavigationAction.ExplanationDone.name -> {
                    navigate(R.id.action_session_explanaition_fragment_to_decomposition)
                }
                NavigationAction.ExerciseDone.name -> {
                    navigate(R.id.action_to_finalize_session_fragment)
                }
                NavigationAction.MessageDone.name -> {
                    //todo need to popup all the fragments
                    popBackStack(R.id.nav_home, false)
                }

            }
        }

    }

}