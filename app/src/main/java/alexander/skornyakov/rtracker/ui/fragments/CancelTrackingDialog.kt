package alexander.skornyakov.rtracker.ui.fragments

import alexander.skornyakov.rtracker.R
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CancelTrackingDialog : DialogFragment() {

    private var yesListener : (()->Unit)? = null

    fun setYesListener(listener: ()->Unit){
        yesListener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
            .setTitle("Cancel the Run?")
            .setMessage("Are you sure to cancel the current run and delete all it's data")
            .setIcon(R.drawable.ic_delete)
            .setPositiveButton("Yes") { _, _ ->
                yesListener?.let { it() }
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog?.cancel()
            }
            .create()

    }
}