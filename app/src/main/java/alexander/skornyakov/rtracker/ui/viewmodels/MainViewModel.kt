package alexander.skornyakov.rtracker.ui.viewmodels

import alexander.skornyakov.rtracker.db.Run
import alexander.skornyakov.rtracker.repositories.MainRepository
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    val repository: MainRepository
): ViewModel() {

    val runsSortedByDate = repository.getAllRunsSortedByDate()

    fun insertRun(run: Run) = viewModelScope.launch {
        repository.insertRun(run)
    }


}