package com.dcac.busschedule.data

import kotlinx.coroutines.flow.Flow

class OfflineBusSchedulesRepository(
    private val busScheduleDao: BusScheduleDao
) : BusSchedulesRepository {

    override fun getAllBusSchedules(): Flow<List<BusSchedule>> = busScheduleDao.getAllBusSchedule()

    override fun getByStopName(stopName: String): Flow<List<BusSchedule>> = busScheduleDao.getByStopName(stopName)
}