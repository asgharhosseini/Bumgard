package ir.ah.app.bumgard.ui.intro


import android.view.*
import androidx.navigation.fragment.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.ui.intro.adapter.*

@AndroidEntryPoint
class IntroFragment : BaseFragment<IntroViewModel>(
    R.layout.fragment_intro, IntroViewModel::class
) {
    private val binding by viewBinding(FragmentIntroBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()
        onRegisterSuccessNavigationResultReceived()
        onLoginSuccessNavigationResultReceived()
        binding.viewPager.adapter = IntroSliderAdapter()
        binding.indicator.setViewPager(binding.viewPager)
        binding.viewPager.isUserInputEnabled = false
        binding.btnSkip.setOnClickListener {
            if (binding.viewPager.currentItem == 1) {
                binding.btnSkip.visibility = View.GONE
                binding.indicator.visibility = View.GONE
                binding.btnGetStart.visibility = View.VISIBLE
            }
            binding.viewPager.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }

        }

        binding.btnGetStart.setOnClickListener {
        findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToSingInFragment())
        }
    }

    private fun onRegisterSuccessNavigationResultReceived() {
        getNavigationResult<Boolean>(Constance.RESULT_REGISTER, findNavController())?.observe(viewLifecycleOwner) {
            removeNavigationResult<Boolean>(Constance.RESULT_REGISTER)
            if (it) {
                setNavigationResult(true, Constance.RESULT_LOGIN)
                findNavController().popBackStack()
            }
        }
    }
    private fun onLoginSuccessNavigationResultReceived() {
        getNavigationResult<Boolean>(Constance.RESULT_LOGIN, findNavController())?.observe(viewLifecycleOwner) {
            removeNavigationResult<Boolean>(Constance.RESULT_LOGIN)
            if (it) {
                setNavigationResult(true, Constance.RESULT_LOGIN)
                findNavController().popBackStack()
            }
        }
    }

}