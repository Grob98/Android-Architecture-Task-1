package de.hsfl.ella8493.taskone.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import de.hsfl.ella8493.taskone.R

class MainFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var tvNumber: TextView
    private lateinit var butPlus: Button
    private lateinit var butMinus: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        tvNumber = requireActivity().findViewById(R.id.tvNumber)
        butPlus = requireActivity().findViewById(R.id.butPlus)
        butMinus = requireActivity().findViewById(R.id.butMinus)

        butPlus.setOnClickListener(this)
        butMinus.setOnClickListener(this)

        setView()
    }

    override fun onClick(v: View?) {
        var currentNumber = viewModel.getNumber()

        when (v!!.id) {
            R.id.butPlus -> viewModel.setNumber(currentNumber+1)
            R.id.butMinus ->  viewModel.setNumber(currentNumber-1)
        }

        setView()
    }

    private fun setView() {
        tvNumber.text = viewModel.getNumber().toString()
    }

}