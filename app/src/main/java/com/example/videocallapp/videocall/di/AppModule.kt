package com.example.videocallapp.videocall.di

import com.example.videocallapp.videocall.VideoCallingApp
import com.example.videocallapp.videocall.connect.ConnectViewModel
import com.example.videocallapp.videocall.video.VideoCallViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    factory {
        val app = androidContext().applicationContext as VideoCallingApp
        app.client
    }

    viewModelOf(::ConnectViewModel)
    viewModelOf(::VideoCallViewModel)
}