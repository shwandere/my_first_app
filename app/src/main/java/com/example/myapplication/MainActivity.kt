package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
//import android.support.design.widget.Snackbar
import com.google.android.material.navigation.NavigationView
//import android.support.design.widget.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
//import androidx.appcompat.app.AppCompatActivity
//import android.support.v7.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
//import android.os.Bundle
import android.widget.Toast
//importkotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*
//import kotlin.
import kotlin.math.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // below code is to add on click
        // listener to our add name button
        addId.setOnClickListener{

            // below we have created
            // a new DBHelper class,
            // and passed context to it
            val db = DBHelper(this, null)

            // creating variables for values
            // in id and logic edit texts
            val id = enterId.toString().toLong()

            val logic = enterLogic.text.toString()

            // calling method to add
            // name to our database
            db.addLogic(id, logic)

            // Toast to message on the screen
            Toast.makeText(this, logic + " added to database", Toast.LENGTH_LONG).show()

            // at last, clearing edit texts
            enterId.text.clear()
            enterLogic.text.clear()
        }

        // below code is to add on click
        // listener to our print name button
        printLogic.setOnClickListener{

            // creating a DBHelper class
            // and passing context to it
            val db = DBHelper(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getLogic()

            // moving the cursor to first position and
            // appending value in the text view
            cursor!!.moveToFirst()
            Id.append(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ID_COL)) + "\n")
            Logic.append(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.LOGIC_COL)) + "\n")

            // moving our cursor to next
            // position and appending values
            while(cursor.moveToNext()){
                Id.append(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ID_COL)) + "\n")
                Logic.append(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.LOGIC_COL)) + "\n")
            }

            // at last we close our cursor
            cursor.close()
        }
    }
}


/*class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}*/
