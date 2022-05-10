package com.example.prohappymultiplatform.android

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.prohappymultiplatform.Constants

class SetupSessionFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var emotionSpinner: Spinner
    private lateinit var severitySpinner: Spinner
    private lateinit var progressBar: ProgressBar
    private lateinit var emotionHeader: TextView
    private lateinit var severityHeader: TextView
    private lateinit var responsibilityHeader: TextView
    private lateinit var screeningHeader: TextView

    private lateinit var goToExplanationButton: com.google.android.material.button.MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_setup_session, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        severitySpinner = view.findViewById(R.id.severity_spinner)
        emotionSpinner = view.findViewById(R.id.emotion_spinner)
        progressBar = view.findViewById(R.id.progress_setup)

        severityHeader = view.findViewById(R.id.severity_header)
        severityHeader.text = Constants.SELECT_SEVERITY_HEADER
        emotionHeader = view.findViewById(R.id.emotion_header)
        emotionHeader.text = Constants.SELECT_EMOTION_HEADER
        responsibilityHeader = view.findViewById(R.id.responsibility_header)
        responsibilityHeader.text = Constants.RESPONSIBILITY_HEADER
        screeningHeader = view.findViewById(R.id.screening_header)
        screeningHeader.text = Constants.SCREENING_HEADER

        goToExplanationButton = view.findViewById(R.id.go_to_explanation_button)
        goToExplanationButton.apply {
            text = Constants.NEXT_PAGE_BUTTON
            setOnClickListener {
                homeViewModel.apply {
                    progressBar.visibility = View.VISIBLE
                    createSession(severity = severitySpinner.selectedItemPosition,
                        selectedEmotion = emotionSpinner.selectedItemPosition,
                        userResponsible = false)
                    progressBar.visibility = View.GONE
                    navigate(NavigationAction.FirstScreeningCompleted.name)
                }
            }
        }
        
        severitySpinner.adapter = NewArrayAdapter(requireActivity(),
            R.layout.spinner_item, R.id.spinner_text_view, Constants.Severity.toMutableList())
        emotionSpinner.adapter = NewArrayAdapter(requireActivity(),
            R.layout.spinner_item, R.id.spinner_text_view, Constants.Emotions.toMutableList())
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
