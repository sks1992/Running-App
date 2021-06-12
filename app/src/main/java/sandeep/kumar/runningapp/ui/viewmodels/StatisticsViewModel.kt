package sandeep.kumar.runningapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import sandeep.kumar.runningapp.repository.MainRepository
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    var totalDistance = mainRepository.getTotalDistance()
    var totalTimeRun = mainRepository.getTotalTimeInMillis()
    var totalAvgSpeed = mainRepository.getTotalAverageSpeed()
    var totalCaloriesBurned = mainRepository.getTotalCaloriesBurned()

    var runsSortedByDate = mainRepository.getAllRunsSortedByDate()
}