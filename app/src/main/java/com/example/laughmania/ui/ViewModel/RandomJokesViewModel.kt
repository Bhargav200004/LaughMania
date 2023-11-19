package com.example.laughmania.ui.ViewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laughmania.data.network.HttpClient
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RandomJokesViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()


    init {
        loading()
    }


    //Function for SwipeLoading
    fun loading(){
        viewModelScope.launch {
            _isLoading.value = false
            delay(3000L)
            _isLoading.value = true
        }
    }


    private val _state = mutableStateOf<RandomJokesState>(RandomJokesState.Loading)
    val state: State<RandomJokesState> = _state


    fun processIntent(intent: RandomJokesIntent) {
        when (intent) {
            is RandomJokesIntent.loadRandomJokes -> loadRandomJokes()
        }
    }


    private fun loadRandomJokes() {

        //Default value
        _state.value = RandomJokesState.Loading

        viewModelScope.launch {
            try {
                _state.value = RandomJokesState.Success(HttpClient.getRandomJokes())
            } catch (e: Exception) {
                _state.value = RandomJokesState.Error("Error\n${e}")
                Log.d("Error","$e")
            }
        }
    }
}

