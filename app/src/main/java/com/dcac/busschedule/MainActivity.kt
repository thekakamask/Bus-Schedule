package com.dcac.busschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dcac.busschedule.ui.BusScheduleApp
import com.dcac.busschedule.ui.theme.BusScheduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BusScheduleTheme {
                BusScheduleApp()
            }
        }
    }
}