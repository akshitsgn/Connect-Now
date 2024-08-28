package com.example.videocallapp.videocall.video

import io.getstream.video.android.core.Call

data class VideoCallState(
    val call: Call,
    val callState: CallState? = null,
    val error: String? = null
)
// enum is used to define our own type call state
enum class CallState {
    JOINING,
    ACTIVE,
    ENDED
}