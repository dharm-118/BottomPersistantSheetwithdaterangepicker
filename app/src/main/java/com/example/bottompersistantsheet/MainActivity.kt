package com.example.bottompersistantsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var show_btn : Button
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        show_btn=findViewById(R.id.uiShow)
        val bottomSheetFragment = BottomSheetFragment()
        show_btn.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager,"BottomSheetDialog")
        }

    }
}