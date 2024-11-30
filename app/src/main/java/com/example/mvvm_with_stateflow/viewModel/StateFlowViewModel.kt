package com.example.mvvm_with_stateflow.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Ratna Srivastava on 30-11-2024.
 */
class StateFlowViewModel: ViewModel() {
    private val _stateFlow = MutableStateFlow("Initial Stage")
    val stateFlow: StateFlow<String> get() = _stateFlow

    fun updateState(state: String) {
        _stateFlow.value = state
    }
}