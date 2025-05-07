package com.dcac.busschedule.data

import android.content.Context

interface AppContainer{
    val busSchedulesRepository: BusSchedulesRepository
}

class AppDataContainer(private val context:Context) : AppContainer {

    override val busSchedulesRepository: BusSchedulesRepository by lazy {
        OfflineBusSchedulesRepository(BusScheduleDatabase.getDatabase(context).busScheduleDao())
    }

}