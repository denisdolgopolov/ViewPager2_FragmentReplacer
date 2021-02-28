package dolgopolov.test.vpfr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager_2.adapter = MyViewPager2Adapter(this)
        TabLayoutMediator(tab_layout, view_pager_2) { tab, position ->
            tab.text = when(position) {
                0 -> "Первый"
                1 -> "Второй"
                2 -> "Крайний"
                else -> throw IllegalStateException()
            }
        }.attach()
    }
}