package com.headfirstandroiddev.app2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
class CreateMessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_create_message, container, false)
        val button = view.findViewById<Button>(R.id.button1_createMessageFragment)
        val editText1 = view.findViewById<EditText>(R.id.editText1_createMessageFragment)
        button.setOnClickListener {
            val action = CreateMessageFragmentDirections.actionCreateMessageFragment2ToEncryptFragment2(editText1
                .text.toString().reversed())
            view.findNavController().navigate(action)
        }
        return view
    }
}