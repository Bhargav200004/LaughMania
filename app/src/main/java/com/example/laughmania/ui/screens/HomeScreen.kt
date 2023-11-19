package com.example.laughmania.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.laughmania.ui.ViewModel.RandomJokesIntent
import com.example.laughmania.ui.ViewModel.RandomJokesState
import com.example.laughmania.ui.ViewModel.RandomJokesViewModel
import com.example.laughmania.ui.component.ErrorComponent
import com.example.laughmania.ui.component.Loading
import com.example.laughmania.ui.component.successComponent


@Composable
fun HomeScreen(randomJokesViewModel: RandomJokesViewModel) {

    val state by randomJokesViewModel.state

    when(state){
        is RandomJokesState.Loading -> Loading()
        is RandomJokesState.Success ->{
            val jokes = (state as RandomJokesState.Success).jokes
            successComponent(jokes = jokes)
        }
        is RandomJokesState.Error ->{
            val message = (state as RandomJokesState.Error).message
            ErrorComponent(message = message)
        }

    }

    LaunchedEffect(Unit){
        randomJokesViewModel.processIntent(RandomJokesIntent.loadRandomJokes)
    }



}