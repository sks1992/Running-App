package sandeep.kumar.runningapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import sandeep.kumar.runningapp.repository.MainRepository
import javax.inject.Inject

class StatisticsViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {

}