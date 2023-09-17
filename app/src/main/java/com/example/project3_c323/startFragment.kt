package com.example.project3_c323

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [startFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class startFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start, container, false)

        // Default number of questions
        var questNum = 10

        // Following code deals with increasing and decreasing the question number
        val qNumTextView = view.findViewById<TextView>(R.id.tQuestionNumber) // TextView
        qNumTextView.text = questNum.toString() // Sets default number of questions

        val bIncrease = view.findViewById<Button>(R.id.bIncrease) // Button for increasing number of questions
        val bDecrease = view.findViewById<Button>(R.id.bDecrease) // Button for decreasing number of questions

        // Listener for increasing question number
        bIncrease.setOnClickListener {
            questNum++
            qNumTextView.text = questNum.toString()
        }

        // Listener for decreasing question number
        bDecrease.setOnClickListener {
            if (questNum > 0){
                questNum--
                qNumTextView.text = questNum.toString()
            }
        }

        var bStart = view.findViewById<Button>(R.id.bStart) // Button for sending the user to the next screen

        // Once the user presses Start, this will send them to the next screen where they'll enter questions.
        bStart.setOnClickListener {
            view.findNavController().navigate(R.id.action_startFragment_to_questionFragment)
        }

        return view
    }
}