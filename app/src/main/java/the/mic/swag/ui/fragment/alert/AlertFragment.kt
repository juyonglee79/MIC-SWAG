package the.mic.swag.ui.fragment.alert

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.util.DataBindingFragment
import dsm.android.v3.presentation.di.scope.ActivityScope
import the.mic.swag.R
import the.mic.swag.databinding.FragmentAlertBinding
import the.mic.swag.domain.repository.alert.AlertRepository
import the.mic.swag.presentation.viewmodel.alert.AlertViewModel
import the.mic.swag.presentation.viewmodel.alert.AlertViewModelFactory

@ActivityScope
class AlertFragment : DataBindingFragment<FragmentAlertBinding>(), AlertRepository {

    override val layoutId: Int
        get() = R.layout.fragment_alert

    private val factory = AlertViewModelFactory(this)

    private val fm: FragmentManager? by lazy { fragmentManager }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!, factory).get(AlertViewModel::class.java)

        binding.vm = viewModel

    }


}