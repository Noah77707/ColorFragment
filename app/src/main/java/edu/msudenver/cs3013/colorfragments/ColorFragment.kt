package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text

class ColorFragment : Fragment() {

    companion object {
        private var fragmentcount = 0

        fun newInstance(choice: Int): ColorFragment {
            return ColorFragment().apply {
                arguments = Bundle().apply {
                    putInt("COLOR_CHOICE", choice)
                }
            }
        }
    }

    private var myIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            fragmentcount++
            myIndex = fragmentcount
        }
    }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val choiceId = arguments?.getInt("COLOR_CHOICE", 0) ?: 0
        val chosenColorTV: TextView = view.findViewById(R.id.myColor)

        when (choiceId) {
            1 -> {
                chosenColorTV.setText("GENERIC BLUE FRAGMENT - UID $myIndex")
                chosenColorTV.setBackgroundColor(Color.rgb(150,150,255))
            }
            2 -> {
                chosenColorTV.setText("GENERIC RED FRAGMENT - UID $myIndex")
                chosenColorTV.setBackgroundColor(Color.rgb(255,150,150))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }
}