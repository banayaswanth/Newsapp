package com.example.etpproject_newsapp

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class pageradapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {
    private val tabcount: Int = behavior
    override fun getCount(): Int {
        return tabcount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> homefragmnet()
            1 -> sportfragmnet()
            2 -> healthfragmnet()
            3 -> sciencefragmnet()
            4 -> entertainmentfragmnet()
            5 -> tecfragmnet()
            else -> throw IllegalStateException("Invalid position $position")
        }
    }


}