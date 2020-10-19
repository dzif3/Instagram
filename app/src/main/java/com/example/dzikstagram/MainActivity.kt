package com.example.dzikstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.dzikstagram.Fragment.HomeFragment
import com.example.dzikstagram.Fragment.NotificationFragment
import com.example.dzikstagram.Fragment.ProfileFragment
import com.example.dzikstagram.Fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_profile.*

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when (item.itemId){
            R.id.nav_home->{
                movetoFragment(HomeFragment())
            return@OnNavigationItemSelectedListener true
        }
            R.id.nav_search->{
                movetoFragment(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_add_post -> {
                item.isChecked = false
                startActivity(Intent(this@MainActivity, TambahPostActivity::class.java))
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_notification->{
                movetoFragment(NotificationFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_profile->{
                movetoFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
    }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        movetoFragment(HomeFragment())
    }
    private fun movetoFragment(fragment: Fragment) {
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }
}