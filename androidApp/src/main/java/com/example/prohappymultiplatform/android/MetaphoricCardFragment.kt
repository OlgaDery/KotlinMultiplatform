package com.example.prohappymultiplatform.android

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.testapp.StaticStrings
import java.io.IOException
import java.io.InputStream
import java.util.*


class MetaphoricCardFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var calculating = false
    private lateinit var cardImageView: ImageView
    private lateinit var cardGenerationLayout: LinearLayout
    private lateinit var cardScrollView: ScrollView
    private lateinit var cardGenerationImage: androidx.cardview.widget.CardView

    val showSubmitButton: Boolean
        get() {
            homeViewModel.sessionRepo?.let {
                return it.cardSelected || (it.session.sessionPatternCode == 19 || it.session.sessionPatternCode == 21
                        || it.session.sessionPatternCode == 17 || it.session.sessionPatternCode == 9)
            }
            return false
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_metaphoric_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardImageView = view.findViewById(R.id.card_image_view)
        cardScrollView = view.findViewById(R.id.card_layout_scrollview)
        cardGenerationLayout = view.findViewById(R.id.select_card_layout)
        cardGenerationImage = view.findViewById(R.id.card_selection_image)
        cardGenerationImage.setOnClickListener {
            generateRandomNumber()
        }
    }

    fun generateRandomNumber() {
        calculating = true
        val ran = Random()
        val randRuneIndex: Int = ran.nextInt(76 - 0 + 1) + 0
        try {
            // get input stream
            val ims: InputStream = requireContext().resources.openRawResource(
                requireContext().resources.getIdentifier(
                    "card_".plus(randRuneIndex.toString()),
                    "raw", requireContext().packageName
                )
            )
            val d = Drawable.createFromStream(ims, null)
            // set image to ImageView
            cardImageView.setImageDrawable(d)
            ims.close()
            cardGenerationLayout.visibility = View.GONE
            cardScrollView.visibility = View.VISIBLE
            calculating = false
            homeViewModel.sessionRepo?.cardSelected = true
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    fun finalizeSession(view: View) {
        Navigation.findNavController(requireActivity(), R.id.login_nav_host_fragment).apply {
            navigate(R.id.action_to_finalize_session_fragment)
        }
    }
}