package com.heyabhi.textviewverticalreveal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivExpand: View = findViewById(R.id.iv_expand)
        val tvSubtitle: TextView = findViewById(R.id.tv_subtitle)

        ivExpand.setOnClickListener {
            tvSubtitle.isVisible = !tvSubtitle.isVisible
        }
    }
}