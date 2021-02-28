package dolgopolov.test.vpfr.fragments

import android.os.Bundle
import android.view.View
import dolgopolov.test.vpfr.BaseFragment
import dolgopolov.test.vpfr.R
import kotlinx.android.synthetic.main.fragment_deep.*

class FragmentDeep : BaseFragment(R.layout.fragment_deep) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b_back.setOnClickListener {
            fragmentReplacer.replaceCurrentToDef()
        }
    }
}