package sandeep.kumar.runningapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import sandeep.kumar.runningapp.R
import sandeep.kumar.runningapp.ui.viewmodels.MainViewModel


@AndroidEntryPoint
class RunFragment : Fragment(R.layout.fragment_run) {

    private val viewModel:MainViewModel by viewModels()

}