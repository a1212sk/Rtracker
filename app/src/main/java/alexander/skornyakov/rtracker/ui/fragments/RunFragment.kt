package alexander.skornyakov.rtracker.ui.fragments

import alexander.skornyakov.rtracker.R
import alexander.skornyakov.rtracker.ui.viewmodels.MainViewModel
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunFragment : Fragment(R.layout.fragment_run){

    private val viewModel: MainViewModel by viewModels()

}