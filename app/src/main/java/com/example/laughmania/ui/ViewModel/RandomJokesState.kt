package com.example.laughmania.ui.ViewModel

import com.example.laughmania.data.models.RandomData

sealed class RandomJokesState{
    object Loading : RandomJokesState()
    data class Success(val jokes : RandomData) : RandomJokesState()
    data class Error(val message: String) : RandomJokesState()
}
