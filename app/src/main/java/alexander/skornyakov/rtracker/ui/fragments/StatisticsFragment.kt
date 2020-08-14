package alexander.skornyakov.rtracker.ui.fragments

import alexander.skornyakov.rtracker.R
import alexander.skornyakov.rtracker.helpers.TrackingUtility
import alexander.skornyakov.rtracker.ui.viewmodels.StatisticsViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlin.math.round

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics){

    private val viewModel: StatisticsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservers()
    }

    private fun subscribeToObservers(){
        viewModel.totalTime.observe(viewLifecycleOwner, Observer {
            it?.let {
                val totalTime = TrackingUtility.getFormattedStopWatchTime(it)
                tvTotalTime.text = totalTime
            }
        })
        viewModel.totalDistance.observe(viewLifecycleOwner, Observer {
            it?.let{
                val km = it / 1000f
                val total = round(km * 10f) / 10f
                val totalStr = "{$total}km"
                tvTotalDistance.text = totalStr
            }
        })
        viewModel.totalAvgSpeed.observe(viewLifecycleOwner, Observer {
            it?.let{
                val avgSpeed = round(it * 10f) / 10f
                val avgSpeedStr = "${avgSpeed}km/h"
                tvAverageSpeed.text = avgSpeedStr
            }
        })
        viewModel.totalCalories.observe(viewLifecycleOwner, Observer {
            it?.let{
                val totalCalories = "${it}kcal"
                tvTotalCalories.text = totalCalories
            }
        })
    }
}