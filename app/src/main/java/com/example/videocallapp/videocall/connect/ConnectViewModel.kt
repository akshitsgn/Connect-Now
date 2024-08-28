package com.example.videocallapp.videocall.connect

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.videocallapp.videocall.VideoCallingApp

class ConnectViewModel(
    private val app: Application
): AndroidViewModel(app) {

    var state by mutableStateOf(ConnectState())
        // state is var containing the features provided by connect State.
        private set
    // private set is used to change the value of var variable inside from this viewmodel only

    fun onAction(action: ConnectAction) {
        when(action) {
            ConnectAction.OnConnectClick -> {
                connectToRoom()
            }
            is ConnectAction.OnNameChange -> {
                state = state.copy(name = action.name)
            }
        }
    }

    private fun connectToRoom() {
        state = state.copy(errorMessage = null)
        // before starting the connection it sets to null useful for deleting previous error
        if(state.name.isBlank()) {
            state = state.copy(
                errorMessage = "The username can't be blank."
            )
            return
        }

        (app as VideoCallingApp).initVideoClient(state.name)

        state = state.copy(isConnected = true)
    }
}