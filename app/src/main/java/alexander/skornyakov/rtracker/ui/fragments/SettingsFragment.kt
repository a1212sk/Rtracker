package alexander.skornyakov.rtracker.ui.fragments

import alexander.skornyakov.rtracker.R
import alexander.skornyakov.rtracker.helpers.Constants.KEY_NAME
import alexander.skornyakov.rtracker.helpers.Constants.KEY_WEIGHT
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFieldsFromSharePrefs()
        btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPref()
            if (success) {
                Snackbar.make(view, "Saved changes", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Please fill out the fields!", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun applyChangesToSharedPref(): Boolean {
        val nameText = etName.text.toString()
        val weight = etWeight.text.toString()
        if (nameText.isEmpty() || weight.isEmpty()) {
            return false
        }
        sharedPreferences.edit()
            .putString(KEY_NAME, nameText)
            .putFloat(KEY_WEIGHT, weight.toFloat())
            .apply()
        val toolbarText = "Let's go $nameText"
        requireActivity().tvToolbarTitle.text = toolbarText
        return true
    }

    private fun loadFieldsFromSharePrefs() {
        val name = sharedPreferences.getString(KEY_NAME, "")
        val weight = sharedPreferences.getFloat(KEY_WEIGHT, 80f)
        etName.setText(name)
        etWeight.setText(weight.toString())
    }

}