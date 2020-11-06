package com.github.cesar1287.exercicioandroid1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class RegisterAdapter(
    private val list: List<String>,
    private val fragments: List<Fragment>,
    manager: FragmentManager
) : FragmentPagerAdapter(
    manager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }
}