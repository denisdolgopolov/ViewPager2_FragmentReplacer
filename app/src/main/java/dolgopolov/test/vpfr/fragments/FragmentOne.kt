package dolgopolov.test.vpfr.fragments

import android.os.Bundle
import android.view.View
import dolgopolov.test.vpfr.BaseFragment
import dolgopolov.test.vpfr.R
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : BaseFragment(R.layout.fragment_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b_replace_fragment_one.setOnClickListener {
            val fragmentDeep = FragmentDeep()

            fragmentReplacer.replace(pagePos, fragmentDeep)
        }
    }
}