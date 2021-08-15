package ir.ah.app.bumgard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.*
import androidx.navigation.*
import androidx.navigation.fragment.*
import androidx.navigation.ui.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.databinding.*
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            binding.fcv.id
        ) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.splashFragment,R.id.singInFragment, R.id.singUpFragment, R.id.introFragment,R.id.loginAgainFragment -> {
                    hideBottomNav()
                }
            }
        }
        binding.bnv.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    fun showBottomNav() {
        binding.bnv.isVisible = true
    }

    fun hideBottomNav() {
        binding.bnv.isVisible = false
    }


}