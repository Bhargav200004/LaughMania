package com.example.laughmania.ui.ViewModel

sealed class RandomJokesIntent{
    object loadRandomJokes : RandomJokesIntent()
}