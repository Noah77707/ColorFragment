package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private val colorChoice = "param1"

class ChoiceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var choiceListener: ChoiceListener? = null

    interface ChoiceListener {
        fun onSelected(choice: Int)
    }

    override fun onAttach(context: android.content.Context) {
        super.onAttach(context)
        if (context is ChoiceListener) {
            choiceListener = context
        } else {
            throw RuntimeException("$context must implement OnChoiceListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        choiceListener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val redT = view.findViewById<TextView>(R.id.redText)
        val blueT = view.findViewById<TextView>(R.id.blueText)

        redT.setBackgroundColor(Color.rgb(255,150,150))
        blueT.setBackgroundColor(Color.rgb(150,150,255))

        redT.setOnClickListener {
            choiceListener?.onSelected(2)
        }

        blueT.setOnClickListener {
            choiceListener?.onSelected(1)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putString(colorChoice, param1)
                }
            }
    }
}