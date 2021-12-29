package com.example.prohappymultiplatform.android

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.testapp.NavigationAction

class SetupSessionFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var emotionSpinner: Spinner
    private lateinit var severitySpinner: Spinner
    private lateinit var convictionsSpinner: Spinner
    private lateinit var goToExplanationButton: com.google.android.material.button.MaterialButton
    private lateinit var negativeConditionChips: com.google.android.material.chip.ChipGroup
    private lateinit var triggerExistedChips: com.google.android.material.chip.ChipGroup

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_setup_session, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        severitySpinner = view.findViewById(R.id.severity_spinner)
        emotionSpinner = view.findViewById(R.id.emotion_spinner)
        convictionsSpinner = view.findViewById(R.id.convictions_spinner)
        negativeConditionChips = view.findViewById(R.id.negative_condition_chip_group)
        triggerExistedChips = view.findViewById(R.id.trigger_existed_chip_group)

        goToExplanationButton = view.findViewById(R.id.go_to_explanation_button)
        goToExplanationButton.setOnClickListener {

            val negativeCondition = negativeConditionChips[0].isSelected
            val triggerExisted = triggerExistedChips[0].isSelected
            System.out.println("negative condition selected and trigger existed: " + negativeCondition + triggerExisted)

            homeViewModel.createSession(severity = severitySpinner.selectedItemPosition,
                selectedConviction = convictionsSpinner.selectedItemPosition,
                selectedEmotion = emotionSpinner.selectedItemPosition,
                criticalConditionConfirmed = negativeCondition,
                triggerExists = triggerExisted, userResponsible = false)
            navigate(NavigationAction.FirstScreeningCompleted.name)
        }

        convictionsSpinner.adapter = NewArrayAdapter(requireActivity(),
            R.layout.spinner_item, R.id.spinner_text_view, resources.getStringArray(R.array.irrational_convictions).toMutableList())
        severitySpinner.adapter = NewArrayAdapter(requireActivity(),
            R.layout.spinner_item, R.id.spinner_text_view, resources.getStringArray(R.array.condition_severity_levels).toMutableList())
        emotionSpinner.adapter = NewArrayAdapter(requireActivity(),
            R.layout.spinner_item, R.id.spinner_text_view, resources.getStringArray(R.array.emotions_negative).toMutableList())
    }

}

class NewArrayAdapter(context: Context, resource: Int, val textView: Int, val items: MutableList<String>) : ArrayAdapter<String>(context, resource, textView, items) {

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        view.post {
            view.findViewById<TextView>(textView).isSingleLine = false
        }
        return view
    }
}
