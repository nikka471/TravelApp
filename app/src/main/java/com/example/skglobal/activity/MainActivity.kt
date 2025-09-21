package com.example.skglobal.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.skglobal.fragment.ExploreFragment
import com.example.skglobal.fragment.LoginFragment
import com.example.skglobal.fragment.MessageFragment
import com.example.skglobal.R
import com.example.skglobal.fragment.TripsFragment
import com.example.skglobal.fragment.WishlistFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)


        loadFragment(ExploreFragment())


        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_explore -> {
                    loadFragment(ExploreFragment())
                    true
                }
                R.id.nav_wishlist -> {
                    loadFragment(WishlistFragment())
                    true
                }
                R.id.nav_trips -> {
                    loadFragment(TripsFragment())
                    true
                }
                R.id.nav_message -> {
                    loadFragment(MessageFragment())
                    true
                }
                R.id.nav_login -> {
                    loadFragment(LoginFragment())
                    true
                }
                else -> false
            }
        }
    }


    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}