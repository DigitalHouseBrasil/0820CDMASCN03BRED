package com.github.cesar1287.desafiopicpayandroid

import android.content.Context
import android.os.Bundle
import android.os.TokenWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_payment.*

class PaymentFragment : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("teste - Fragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("teste - Fragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("teste - Fragment", "onViewCreated")
        turma3.text = "Aula 23"
        dismiss.setOnClickListener {
            Toast.makeText(requireContext(), "Cliquei no botão", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("teste - Fragment", "onActivityCreated")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("teste - Fragment", "onAttach")
    }

    override fun onStart() {
        super.onStart()

        Log.i("teste - Fragment", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("teste - Fragment", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("teste - Fragment", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("teste - Fragment", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("teste - Fragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()

        Log.i("teste - Fragment", "onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("teste - Fragment", "onDestroyView")
    }
}