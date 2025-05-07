package com.dcac.busschedule.data

import kotlinx.coroutines.flow.Flow

interface BusSchedulesRepository {

    fun getAllBusSchedules(): Flow<List<BusSchedule>>
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}