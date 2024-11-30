package com.example.mvvm_with_stateflow

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.mvvm_with_stateflow.viewModel.StateFlowViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        lifecycleScope.launch{
            viewModel.stateFlow.collect {
                state -> textView.text = state
            }
        }

        button.setOnClickListener {
            viewModel.updateState("New State")
        }
    }

    private val viewModel: StateFlowViewModel by viewModels()
}