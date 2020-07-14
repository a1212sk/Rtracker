package alexander.skornyakov.rtracker.ui.viewmodels

import alexander.skornyakov.rtracker.repositories.MainRepository
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class MainViewModel @ViewModelInject constructor(
    val repository: MainRepository
): ViewModel() {



}