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

import kotlinx.coroutines.*
import javax.inject.*
@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel>(
    R.layout.fragment_splash, SplashViewModel::class
) {
    private val binding by viewBinding(FragmentSplashBinding::bind)


    override fun observeData() {
        super.observeData()
        lifecycleScope.launch {
            delay(2000)
        }
    }

    override fun setUpViews() {
        super.setUpViews()

    }


}