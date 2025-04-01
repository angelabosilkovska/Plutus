package com.compose.plutus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.plutus.data.UserData
import com.compose.plutus.network.UserDataClient
import com.compose.plutus.util.NetworkError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.compose.plutus.util.Result

class AppViewModel (
    private val client: UserDataClient
) : ViewModel() {

    private val _userData = MutableStateFlow<Result<UserData, NetworkError>?>(null)
    val userData: StateFlow<Result<UserData, NetworkError>?> = _userData

    init {
        fetchUserData()
    }

    fun fetchUserData() {
        viewModelScope.launch {
            _userData.value = client.getUserData()
        }
    }
}