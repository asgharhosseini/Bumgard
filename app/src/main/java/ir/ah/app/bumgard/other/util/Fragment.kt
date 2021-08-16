package ir.ah.app.bumgard.other.util

import android.widget.*
import androidx.fragment.app.*
import androidx.lifecycle.*
import androidx.navigation.*
import androidx.navigation.fragment.*


fun Fragment.longToast(msg: String) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
}

fun Fragment.longToast(msg: Int) {
    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
}


private fun getCurrentBackStack(
    navController: NavController,
    destination: Int?,
) = destination?.let(navController::getBackStackEntry) ?: navController.currentBackStackEntry

fun <T> Fragment.getNavigationResult(
    key: String = "result",
    navController: NavController = findNavController(),
    destination: Int? = null,
): MutableLiveData<T>? =
    getCurrentBackStack(navController, destination)?.savedStateHandle?.getLiveData(key)

fun <T> Fragment.setNavigationResult(
    result: T?,
    key: String = "result",
    navController: NavController = findNavController(),
): Unit = navController.previousBackStackEntry?.savedStateHandle?.set(key, result) ?: Unit

fun <T> Fragment.removeNavigationResult(
    key: String = "result",
    navController: NavController = findNavController(),
    destination: Int? = null,
): T? = getCurrentBackStack(navController, destination)?.savedStateHandle?.remove(key)