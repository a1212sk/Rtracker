package alexander.skornyakov.rtracker.ui.viewmodels

import alexander.skornyakov.rtracker.db.Run
import alexander.skornyakov.rtracker.helpers.SortType
import alexander.skornyakov.rtracker.repositories.MainRepository
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val repository: MainRepository
) : ViewModel() {

    private val runsSortedByDate = repository.getAllRunsSortedByDate()
    private val runsSortedByAvgSpeed = repository.getAllRunsSortedByAvgSpeed()
    private val runsSortedByCalories = repository.getAllRunsSortedByCalories()
    private val runsSortedByDistance = repository.getAllRunsSortedByDistance()
    private val runsSortedByTime = repository.getAllRunsSortedByTime()

    val runs = MediatorLiveData<List<Run>>()

    var sortType = SortType.DATE

    init {
        runs.addSource(runsSortedByDate) {
            if (sortType == SortType.DATE) {
                it?.let {
                    runs.value = it
                }
            }
        }
        runs.addSource(runsSortedByAvgSpeed) {
            if (sortType == SortType.AVG_SPEED) {
                it?.let {
                    runs.value = it
                }
            }
        }
        runs.addSource(runsSortedByCalories) {
            if (sortType == SortType.CALORIES_BURNED) {
                it?.let {
                    runs.value = it
                }
            }
        }
        runs.addSource(runsSortedByDistance) {
            if (sortType == SortType.DISTANCE) {
                it?.let {
                    runs.value = it
                }
            }
        }
        runs.addSource(runsSortedByTime) {
            if (sortType == SortType.RUNNING_TIME) {
                it?.let {
                    runs.value = it
                }
            }
        }

    }

    fun insertRun(run: Run) = viewModelScope.launch {
        repository.insertRun(run)
    }

    fun sortRuns(sortType: SortType) = when(sortType){
        SortType.DATE -> runsSortedByDate.value?.let { runs.value = it }
        SortType.AVG_SPEED -> runsSortedByAvgSpeed.value?.let { runs.value = it }
        SortType.CALORIES_BURNED -> runsSortedByCalories.value?.let { runs.value = it }
        SortType.DISTANCE -> runsSortedByDistance.value?.let { runs.value = it }
        SortType.RUNNING_TIME -> runsSortedByTime.value?.let { runs.value = it }
    }.also {
        this.sortType = sortType
    }


}