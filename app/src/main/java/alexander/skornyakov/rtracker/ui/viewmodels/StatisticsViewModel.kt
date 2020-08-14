package alexander.skornyakov.rtracker.ui.viewmodels

import alexander.skornyakov.rtracker.repositories.MainRepository
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class StatisticsViewModel @ViewModelInject constructor(
    val repository: MainRepository
): ViewModel() {

    val totalTime = repository.getTotalTime()
    val totalDistance = repository.getTotalDistance()
    val totalCalories = repository.getTotalCalories()
    val totalAvgSpeed = repository.getTotalAvgSpeed()

    val runsSortedByDate = repository.getAllRunsSortedByDate()

}