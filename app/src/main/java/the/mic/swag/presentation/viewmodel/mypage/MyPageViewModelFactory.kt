package the.mic.swag.presentation.viewmodel.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import the.mic.swag.domain.repository.mypage.MyPageRepository

class MyPageViewModelFactory(val myPageRepository: MyPageRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        return MyPageViewModel(myPageRepository) as T
    }
}
