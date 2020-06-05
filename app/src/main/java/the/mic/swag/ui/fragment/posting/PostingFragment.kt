package the.mic.swag.ui.fragment.posting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.android.dutchman.util.DataBindingFragment
import the.mic.swag.R
import the.mic.swag.databinding.FragmentPostBinding
import the.mic.swag.domain.repository.posting.PostingRepository
import the.mic.swag.presentation.viewmodel.posting.PostingViewModel
import the.mic.swag.presentation.viewmodel.posting.PostingViewModelFactory

class PostingFragment: DataBindingFragment<FragmentPostBinding>(), PostingRepository {

    override val layoutId: Int
    get() = R.layout.fragment_post

    private val factory = PostingViewModelFactory(this)

    private val fm: FragmentManager? by lazy { fragmentManager }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity!!, factory).get(PostingViewModel::class.java)

        binding.vm = viewModel

    }


}