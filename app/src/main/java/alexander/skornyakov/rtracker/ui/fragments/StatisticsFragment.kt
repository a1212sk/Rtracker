package alexander.skornyakov.rtracker.ui.fragments

import alexander.skornyakov.rtracker.R
import alexander.skornyakov.rtracker.ui.viewmodels.StatisticsViewModel
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics){

    private val viewModel: StatisticsViewModel by viewModels()

}