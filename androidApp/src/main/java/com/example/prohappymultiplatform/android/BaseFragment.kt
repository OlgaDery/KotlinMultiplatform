package com.example.prohappymultiplatform.android

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

open class BaseFragment : Fragment() {

    fun navigate(viewTag: String) {
        Navigation.findNavController(requireActivity(), R.id.login_nav_host_fragment).apply {
            when (viewTag) {
                NavigationAction.StartSession.name -> {
                    navigate(R.id.home_fragment_to_start_session_fragment)
                }
                NavigationAction.FirstScreeningCompleted.name -> {
                    navigate(R.id.action_session_explanaition_fragment_to_decomposition)
                }
                NavigationAction.ExerciseDone.name -> {
                    navigate(R.id.action_to_finalize_session_fragment)
                }
                NavigationAction.MessageDone.name -> {
                    popBackStack(R.id.nav_home, false)
                }

            }
        }
    }
}

enum class NavigationAction {
    StartSession, FirstScreeningCompleted, ExerciseDone, MessageDone
}