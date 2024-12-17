package com.example.roomlocal

import android.app.Application
import com.example.roomlocal.dependenciesinjection.ContainerApp

class KrsApp :Application() {
    lateinit var containerApp: ContainerApp // fungsinya untuk menyimpan instance

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}