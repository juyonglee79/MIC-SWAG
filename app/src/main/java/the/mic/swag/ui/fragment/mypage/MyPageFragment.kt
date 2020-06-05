package the.mic.swag.ui.fragment.mypage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.util.DataBindingFragment
import dsm.android.v3.presentation.di.scope.ActivityScope
import the.mic.swag.R
import the.mic.swag.databinding.FragmentMyPageBinding
import the.mic.swag.domain.repository.mypage.MyPageRepository
import the.mic.swag.presentation.viewmodel.mypage.MyPageViewModel
import the.mic.swag.presentation.viewmodel.mypage.MyPageViewModelFactory

@ActivityScope
class MyPageFragment  : DataBindingFragment<FragmentMyPageBinding>(), MyPageRepository {

    override val layoutId: Int
        get() = R.layout.fragment_my_page

    private val factory = MyPageViewModelFactory(this)

    private val fm: FragmentManager? by lazy { fragmentManager }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!, factory).get(MyPageViewModel::class.java)

        binding.vm = viewModel

    }


}