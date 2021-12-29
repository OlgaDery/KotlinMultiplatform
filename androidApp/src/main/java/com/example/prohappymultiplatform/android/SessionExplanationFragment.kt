package com.example.prohappymultiplatform.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.testapp.NavigationAction
import com.example.testapp.StaticStrings

class SessionExplanationFragment : BaseFragment() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var goToExerciseButton: com.google.android.material.button.MaterialButton

    val userMessage: String by lazy {
        when (homeViewModel.sessionRepo?.session?.sessionPatternCode) {

            StaticStrings.NO_DECOMPOSIT_BAD_TRIGGER_DETECTED_HW -> {
                //disorder
                "Вы отметили, что ваше состояние связано с травматизирующими событиями. Это ограничивает нас в выборе " +
                        "упражнений для проработки проблемы. Наряду с предложенными заданиями рекомендуем вам " +
                        "связаться со специалистом или позвонить по телефону горячей линии."
            }

            StaticStrings.NO_DECOMPOSIT_DISORDERS_DETECTED_HW -> {
                //bad trigger
                "Вы отметили, что ваше состояние сопровождается психическими проявлениями, которые могут потенциально " +
                        "опасны для вас или вашего окружения. Наряду с предложенными заданиями рекомендуем вам " +
                        "связаться со специалистом."
            }

            else ->  "Мы рекомендуем вам пройти предложенное упражнение, которое поможет вам снизить уровень эмоционального дискомфорта." //"Мы сгенерировали ваше домашнее задание в соответствие с выбранным вами сценарием работы. "
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
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
