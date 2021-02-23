package com.kdroid.usecasedemoapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity : AppCompatActivity() {


    fun replaceFragment(
        fragment: Fragment?,
        bundle: Bundle?,
        container: Int,
        isAddToStack: Boolean,
        tag: String?
    ) {
        if (fragment != null) {
            val fragmentTransaction = supportFragmentManager
                .beginTransaction()
            if (isAddToStack) {
//                fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_bottom, R.anim.slide_in_bottom, R.anim.slide_out_bottom);
                fragmentTransaction.addToBackStack(null)
            }
            if (bundle != null) fragment.setArguments(bundle)
            fragmentTransaction.replace(container, fragment, tag)
            fragmentTransaction.commitAllowingStateLoss()
        }
    }

    fun addFragment(
        fragment: Fragment,
        bundle: Bundle?,
        container: Int,
        isAddToStack: Boolean,
        tag: String?
    ): Boolean {
        //   if (fragment != null && isActivityActive) {
        val fragmentTransaction = supportFragmentManager
            .beginTransaction()
        if (isAddToStack) {
//                fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_bottom, R.anim.slide_in_bottom, R.anim.slide_out_bottom);
            fragmentTransaction.addToBackStack(null)
        }
        if (bundle != null) fragment.arguments = bundle
        fragmentTransaction.add(container, fragment, tag)
        fragmentTransaction.commitAllowingStateLoss()
        return true
    }

}