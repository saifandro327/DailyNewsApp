package com.app.dailynewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.app.dailynewsapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationview.setupWithNavController(newsNavHostFragment.findNavController())


    }
}