package com.dcac.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.dcac.busschedule.data.BusSchedule
import kotlinx.coroutines.flow.Flow
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.viewmodel.initializer
import com.dcac.busschedule.BusScheduleApplication
import com.dcac.busschedule.data.BusSchedulesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class BusScheduleViewModel(private val busSchedulesRepository: BusSchedulesRepository): ViewModel() {

    fun getFullSchedule(): Flow<List<BusSchedule>> = busSchedulesRepository.getAllBusSchedules()
    // Get bus schedule based on the stop name from Room DB
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> =
        busSchedulesRepository.getByStopName(stopName)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                BusScheduleViewModel(
                    busScheduleApplication().container.busSchedulesRepository
                )
            }
        }
    }
}

fun CreationExtras.busScheduleApplication(): BusScheduleApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as BusScheduleApplication)