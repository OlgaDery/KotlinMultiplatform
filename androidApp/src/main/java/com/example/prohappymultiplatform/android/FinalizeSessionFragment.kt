package com.example.prohappymultiplatform.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.prohappymultiplatform.Constants
import com.google.android.material.button.MaterialButton

class FinalizeSessionFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var finishSessionButton: MaterialButton
    private lateinit var messageToFutureHeader: TextView
    private lateinit var messageToFutureText: EditText


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_finalize_session, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageToFutureHeader = view.findViewById(R.id.message_to_future_question_text)
        messageToFutureHeader.text = Constants.MESSAGE_TO_FUTURE

        messageToFutureText = view.findViewById(R.id.message_to_future_edit_text)

        finishSessionButton = view.findViewById(R.id.finish_session)
        finishSessionButton.let {
            it.text = Constants.NEXT_PAGE_BUTTON
            it.setOnClickListener {
                homeViewModel.saveMessageToFuture(messageToFutureText.text.toString())
                navigate(NavigationAction.MessageDone.name)
            }
        }
    }

}
