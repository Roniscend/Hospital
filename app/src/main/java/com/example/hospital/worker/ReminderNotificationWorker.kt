package com.example.hospital.worker

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.hospital.utils.NotificationHelper

class ReminderNotificationWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                NotificationHelper.createNotificationChannel(applicationContext)
                val notification = NotificationHelper.createVitalsReminderNotification(applicationContext)

                with(NotificationManagerCompat.from(applicationContext)) {
                    notify(NotificationHelper.NOTIFICATION_ID, notification)
                }
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

    companion object {
        const val WORK_NAME = "PregnancyVitalsReminderWork"
    }
}
