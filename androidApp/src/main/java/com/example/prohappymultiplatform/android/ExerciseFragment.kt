package com.example.prohappymultiplatform.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import com.example.testapp.StaticStrings

class ExerciseFragment : Fragment() {

    private lateinit var viewStub: ViewStub
    private lateinit var finalizeSessionButton: com.google.android.material.button.MaterialButton
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewStub = view.findViewById(R.id.layout_card_stub)
        finalizeSessionButton = view.findViewById(R.id.finalize_session_button)

        viewStub.apply {
            //TODO there should be more possible exersises
            layoutResource =
                when (homeViewModel.sessionRepo?.session?.sessionPatternCode) {
                    StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_3_STORIES -> {
                        R.layout.layout_session_three_stories
                    }
                    StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV -> {
                        R.layout.layout_session_working_on_mistakes
                    }
                    StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION -> {
                        R.layout.positive_aspects
                    }
                    else -> {
                        R.layout.layout_working_with_expectations
                    }
                }
            inflate()
        }
    }
}