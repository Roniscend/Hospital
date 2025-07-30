package com.example.hospital

import android.app.Application
import com.example.hospital.utils.NotificationHelper
import com.example.hospital.utils.WorkManagerHelper

class HospitalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        NotificationHelper.createNotificationChannel(this)
        WorkManagerHelper.scheduleVitalsReminderWork(this)
    }
}
