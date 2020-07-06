package the.mic.swag.ui.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import the.mic.swag.R
import the.mic.swag.ui.fragment.alert.AlertFragment
import the.mic.swag.ui.fragment.mypage.MyPageFragment
import the.mic.swag.ui.fragment.posting.PostingFragment
import the.mic.swag.ui.fragment.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private val backButtonSubject: Subject<Long> =
        BehaviorSubject.createDefault(0L)
            .toSerialized()

    private val backButtonSubjectDisposable: Disposable = backButtonSubject
        .buffer(2, 1)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            if (it[1] - it[0] <= 1500) finish()
            else toast("뒤로가기 버튼을 한 번 더 누르시면 종료됩니다.")
        }

    override fun onBackPressed() {
        if (main_bottom_navigation.selectedItemId == R.id.navigation_posting)
            backButtonSubject.onNext(System.currentTimeMillis())
        else main_bottom_navigation.selectedItemId = R.id.navigation_posting
    }

    private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_posting -> {
                transaction.replace(R.id.main_container, PostingFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                transaction.replace(R.id.main_container, SearchFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_add_post -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_alert -> {
                transaction.replace(R.id.main_container, AlertFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my_page -> {
                transaction.replace(R.id.main_container, MyPageFragment())
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().run {
            replace(R.id.main_container, PostingFragment())
            commit()
        }
        main_bottom_navigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        backButtonSubjectDisposable.dispose()
    }
}
