package alexander.skornyakov.rtracker.ui

import alexander.skornyakov.rtracker.R
import alexander.skornyakov.rtracker.db.RunDao
import alexander.skornyakov.rtracker.helpers.Constants
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToTrackingFragmentIfNeeded(intent)

        setSupportActionBar(toolbar)
        bottomNavigationView.setupWithNavController(nav_host_fragment.findNavController())
        bottomNavigationView.setOnNavigationItemReselectedListener { /* NOP */ }
        nav_host_fragment.findNavController()
            .addOnDestinationChangedListener { _, destination, _ ->
                when(destination.id){
                    R.id.settingsFragment, R.id.statisticsFragment, R.id.runFragment ->
                        bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

    fun navigateToTrackingFragmentIfNeeded(intent: Intent?){
        if(intent?.action == Constants.ACTION_SHOW_TRACKING_FRAGMENT){
            nav_host_fragment.findNavController().navigate(R.id.action_global_trackingFragment)
        }
    }
}