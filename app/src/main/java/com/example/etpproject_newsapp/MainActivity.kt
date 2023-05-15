package com.example.etpproject_newsapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var pagerAdapter: pageradapter
    lateinit var mtoolbar: Toolbar
    private val API_KEY = "b3b451d320574d84b513c2084cf506d7"
    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mtoolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mtoolbar)
        val mhome = findViewById<TabItem>(R.id.home)
        val mscience = findViewById<TabItem>(R.id.science)
        val mhealth = findViewById<TabItem>(R.id.health)
        val mtech = findViewById<TabItem>(R.id.technology)
        val mentertainment = findViewById<TabItem>(R.id.entertainment)
        val msports = findViewById<TabItem>(R.id.sports)



            val viewPager: ViewPager = findViewById(R.id.fragmentcontainer)
        tabLayout = findViewById(R.id.include)

        pagerAdapter = pageradapter(supportFragmentManager, 6)
        viewPager.adapter = pagerAdapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                if (tab.position == 0 || tab.position == 1 || tab.position == 2 || tab.position == 3 || tab.position == 4 || tab.position == 5) {
                    pagerAdapter.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))



        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    val i = Intent(this,MainActivity::class.java)
                    startActivity(i)
                    true
                }
                R.id.account -> {
                    val i = Intent(this,Account::class.java)
                    startActivity(i)

                    true
                }
                R.id.logout -> {
                    val i = Intent(this,loginscreen::class.java)
                    startActivity(i)

                    true
                }
                else ->
                {
                    false
                }

            }
        }

    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentcontainer,fragment)
        transaction.commit()
    }

}