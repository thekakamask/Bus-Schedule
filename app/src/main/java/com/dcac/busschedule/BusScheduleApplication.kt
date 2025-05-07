package com.dcac.busschedule

import android.app.Application
import com.dcac.busschedule.data.AppContainer
import com.dcac.busschedule.data.AppDataContainer

class BusScheduleApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}