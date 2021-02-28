package dolgopolov.test.vpfr

import android.util.ArrayMap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import dolgopolov.test.vpfr.fragments.FragmentOne
import dolgopolov.test.vpfr.fragments.FragmentThree
import dolgopolov.test.vpfr.fragments.FragmentTwo

class MyViewPager2Adapter(container: FragmentActivity) : FragmentStateAdapter(container),
    FragmentReplacer {

    companion object {
        private const val PAGE_COUNT = 3
    }

    override var lastReplacedPos = 0

    private val mapOfFragment = ArrayMap<Int, BaseFragment>()


    override fun replace(position: Int, newFragment: BaseFragment, isNotify: Boolean) {
        newFragment.setPageInfo(
            pagePos = position,
            fragmentReplacer = this
        )

        mapOfFragment[position] = newFragment
        if (isNotify)
            notifyItemChanged(position)
    }

    override fun replaceDef(position: Int, isNotify: Boolean): BaseFragment {
        val fragment = when (position) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            else -> throw IllegalStateException()
        }

        replace(position, fragment, isNotify)

        return fragment
    }

    override fun replaceCurrentToDef() {
        replaceDef(lastReplacedPos)
    }


    override fun createFragment(position: Int): Fragment {
        return mapOfFragment[position] ?: replaceDef(position, false)
    }

    override fun containsItem(itemId: Long): Boolean {
        var isContains = false
        mapOfFragment.values.forEach {
            if (it.pageId == itemId) {
                isContains = true
                return@forEach
            }
        }
        return isContains
    }

    override fun getItemId(position: Int) =
        mapOfFragment[position]?.pageId ?: super.getItemId(position)

    override fun getItemCount() = PAGE_COUNT
}