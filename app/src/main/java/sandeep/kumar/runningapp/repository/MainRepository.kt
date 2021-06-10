package sandeep.kumar.runningapp.repository

import sandeep.kumar.runningapp.db.Run
import sandeep.kumar.runningapp.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDAO: RunDAO
) {

    suspend fun insertRun(run:Run) = runDAO.insertRun(run)

    suspend fun deleteRun(run: Run) =runDAO.deleteRun(run)

    fun getAllRunsSortedByDate() =runDAO.getAllRunsSortedByDate()
    fun getAllRunsSortedByDistance() =runDAO.getAllRunsSortedByDistance()
    fun getAllRunsSortedByTimeInMillis() =runDAO.getAllRunsSortedByTimeInMillis()
    fun getAllRunsSortedByAverageSpeed() =runDAO.getAllRunsSortedByAverageSpeed()
    fun getAllRunsSortedByCaloriesBurned() =runDAO.getAllRunsSortedByCaloriesBurned()

    fun getTotalAverageSpeed() =runDAO.getTotalAverageSpeed()
    fun getTotalDistance() =runDAO.getTotalDistance()
    fun getTotalCaloriesBurned() =runDAO.getTotalCaloriesBurned()
    fun getTotalTimeInMillis() =runDAO.getTotalTimeInMillis()
}