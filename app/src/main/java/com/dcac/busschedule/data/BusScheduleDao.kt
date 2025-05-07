package com.dcac.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

    @Query("SELECT * FROM bus_schedules ORDER BY arrival_time ASC")
    fun getAllBusSchedule(): Flow<List<BusSchedule>>

    @Query("SELECT * FROM bus_schedules WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getByStopName(stopName : String): Flow<List<BusSchedule>>

}