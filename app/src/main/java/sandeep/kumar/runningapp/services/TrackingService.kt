package sandeep.kumar.runningapp.services

import android.content.Intent
import androidx.lifecycle.LifecycleService
import sandeep.kumar.runningapp.util.Constants.ACTION_PAUSE_SERVICE
import sandeep.kumar.runningapp.util.Constants.ACTION_START_OR_RESUME_SERVICE
import sandeep.kumar.runningapp.util.Constants.ACTION_STOP_SERVICE
import timber.log.Timber

class TrackingService : LifecycleService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.let {
            when (it.action){
                ACTION_START_OR_RESUME_SERVICE ->{
                    Timber.d("Started or Resumed Service")
                }
                ACTION_PAUSE_SERVICE ->{
                    Timber.d("Paused Service")
                }
                ACTION_STOP_SERVICE ->{
                    Timber.d("Stop Service")
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)

    }
}