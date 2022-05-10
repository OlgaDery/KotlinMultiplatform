package com.example.prohappymultiplatform.android

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.prohappymultiplatform.Constants
import com.google.android.material.button.MaterialButton
import java.io.IOException
import java.io.InputStream


class MetaphoricCardFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var calculating = false
    private lateinit var cardImageView: ImageView
    private lateinit var emotion_of_card: TextView
    private lateinit var card_connection: TextView
    private lateinit var card_resolution: TextView
    private lateinit var metaph_card_header: TextView
    private lateinit var nextStepButton: MaterialButton
    private lateinit var emotionSpinner: Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_metaphoric_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        metaph_card_header = view.findViewById(R.id.metaph_card_header)
        metaph_card_header.text = Constants.METAPHORIC_CARD_HEADER
        emotion_of_card = view.findViewById(R.id.emotion_of_card)
        emotion_of_card.text = Constants.CARD_EMOTION
        card_connection = view.findViewById(R.id.card_connection)
        card_connection.text = Constants.CONNECTION_WITH_YOUR_LIFE
        card_resolution = view.findViewById(R.id.card_resolution)
        card_resolution.text = Constants.TODAY_RESOLUTION
        cardImageView = view.findViewById(R.id.card_image_view)
        nextStepButton = view.findViewById(R.id.go_to_final_step)
        nextStepButton.let {
            it.text = Constants.NEXT_PAGE_BUTTON
            it.setOnClickListener {
                finalizeSession()
            }
        }
        emotionSpinner = view.findViewById(R.id.session_emotion_spinner)
        emotionSpinner.adapter = NewArrayAdapter(requireActivity(),
            R.layout.spinner_item, R.id.spinner_text_view, Constants.Emotions.toMutableList())
        displayCardBasedOnRandomNumber()
    }

    fun displayCardBasedOnRandomNumber() {
        try {
            // get input stream
            val res = requireContext().resources.getIdentifier(
                    "card_".plus(homeViewModel.sessionRepo?.session?.sessionPatternCode.toString()),
                    "raw", requireContext().packageName)
            val ims: InputStream = requireContext().resources.openRawResource(res)
            val d = Drawable.createFromStream(ims, null)
            // set image to ImageView
            cardImageView.setImageDrawable(d)
            ims.close()
            calculating = false
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    fun finalizeSession() {
        Navigation.findNavController(requireActivity(), R.id.login_nav_host_fragment).apply {
            navigate(R.id.action_to_finalize_session_fragment)
        }
    }
}