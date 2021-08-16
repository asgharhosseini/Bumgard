package ir.ah.app.bumgard.ui.splash

import androidx.core.view.*
import androidx.lifecycle.*
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.util.Constance.RESULT_LOGIN
import ir.ah.app.bumgard.other.wrapper.*

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*
@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel>(
    R.layout.fragment_splash, SplashViewModel::class
) {
    private val binding by viewBinding(FragmentSplashBinding::bind)


    override fun observeData() {
        super.observeData()
        lifecycleScope.launchWhenStarted {
            delay(2000)
            vm.splashEvent.collectLatest { event ->
                handleResource(event, vm::refreshToken)
                when (event) {
                    is Resource.Failure -> {

                    }
                    Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        if (event.success) {
                            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToAuth())
                        } else {
                            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSearchFragment())
                        }
                    }
                }
            }
        }
    }
    private fun getLoginNavigationResult() {
        getNavigationResult<Boolean>(
            RESULT_LOGIN,
            findNavController()
        )?.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSearchFragment())
                mainActivity?.showBottomNav()
            }
        }
    }
    override fun setUpViews() {
        super.setUpViews()
        getLoginNavigationResult()
    }


}