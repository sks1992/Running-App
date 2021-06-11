package sandeep.kumar.runningapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import sandeep.kumar.runningapp.MainActivity
import sandeep.kumar.runningapp.R
import sandeep.kumar.runningapp.util.Constants.ACTION_PAUSE_SERVICE
import sandeep.kumar.runningapp.util.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import sandeep.kumar.runningapp.util.Constants.ACTION_START_OR_RESUME_SERVICE
import sandeep.kumar.runningapp.util.Constants.ACTION_STOP_SERVICE
import sandeep.kumar.runningapp.util.Constants.NOTIFICATION_CHANNEL_ID
import sandeep.kumar.runningapp.util.Constants.NOTIFICATION_CHANNEL_NAME
import sandeep.kumar.runningapp.util.Constants.NOTIFICATION_ID
import timber.log.Timber

class TrackingService : LifecycleService() {

    var isFirstRun = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    if(isFirstRun){
                        startForGroundService()
                        isFirstRun =false
                    } else {
                        Timber.d("Resuming Service ...")
                    }
                }
                ACTION_PAUSE_SERVICE -> {
                    Timber.d("Paused Service")
                }
                ACTION_STOP_SERVICE -> {
                    Timber.d("Stop Service")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForGroundService() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            createNotificationChannel(notificationManager)
        }

        val notificationBuild = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
            .setContentTitle("Running App")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())


        startForeground(NOTIFICATION_ID,notificationBuild.build())
    }

    private fun getMainActivityPendingIntent()=PendingIntent.getActivity(
        this,
        0,
        Intent(this,MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {

        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)
    }
}