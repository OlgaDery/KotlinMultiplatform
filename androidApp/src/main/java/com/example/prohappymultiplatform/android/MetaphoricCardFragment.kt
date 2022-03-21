package com.example.prohappymultiplatform.android

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import java.io.IOException
import java.io.InputStream


class MetaphoricCardFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var calculating = false
    private lateinit var cardImageView: ImageView
    private lateinit var nextStepButton: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_metaphoric_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //metaph_card_header
        //emotion_of_card
        //card_connection
        //card_resolution
        //card_message
        cardImageView = view.findViewById(R.id.card_image_view)
        nextStepButton = view.findViewById(R.id.go_to_final_step)
        nextStepButton.setOnClickListener {
            finalizeSession()
        }
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