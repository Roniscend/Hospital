package com.example.hospital.utils
import android.content.Context
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.hospital.worker.ReminderNotificationWorker
import java.util.concurrent.TimeUnit

object WorkManagerHelper {

    fun scheduleVitalsReminderWork(context: Context) {
        val workRequest = PeriodicWorkRequestBuilder<ReminderNotificationWorker>(
            5, TimeUnit.HOURS
        )
            .setInitialDelay(5, TimeUnit.HOURS)
            .build()
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            ReminderNotificationWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest
        )
    }

    fun cancelVitalsReminderWork(context: Context) {
        WorkManager.getInstance(context).cancelUniqueWork(
            ReminderNotificationWorker.WORK_NAME
        )
    }
}
