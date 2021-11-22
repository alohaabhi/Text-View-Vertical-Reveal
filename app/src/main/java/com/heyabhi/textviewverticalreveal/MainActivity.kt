package com.heyabhi.textviewverticalreveal

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import com.heyabhi.textviewverticalreveal.extensions.toPx
import com.heyabhi.textviewverticalreveal.extensions.updateHeight

class MainActivity : AppCompatActivity() {

    private lateinit var tvSubtitle: TextView
    private lateinit var clContainer: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivExpand: View = findViewById(R.id.iv_expand)
        tvSubtitle = findViewById(R.id.tv_subtitle)
        clContainer = findViewById(R.id.cl_container)

        ivExpand.setOnClickListener {
            if (!tvSubtitle.isVisible) {
                showSubtitle()
                ivExpand.rotation = 180f
            } else {
                hideSubtitle()
                ivExpand.rotation = 0f
            }
        }
    }

    private fun hideSubtitle() {
        val subtitleHeight = tvSubtitle.height
        val heightAnimator = ValueAnimator.ofInt(subtitleHeight, 0)

        heightAnimator.addUpdateListener {
            tvSubtitle.updateHeight(it.animatedValue as Int)
        }
        heightAnimator.doOnEnd {
            tvSubtitle.isVisible = false
        }
        heightAnimator.start()
    }

    private fun showSubtitle() {
        tvSubtitle.updateHeight(ConstraintLayout.LayoutParams.WRAP_CONTENT)

        val totalMarginForSubtitle = 2 * 16.toPx()
        tvSubtitle.measure(
            View.MeasureSpec.makeMeasureSpec(
                clContainer.width - totalMarginForSubtitle,
                View.MeasureSpec.EXACTLY
            ),
            View.MeasureSpec.UNSPECIFIED
        )
        val subtitleHeight = tvSubtitle.measuredHeight

        tvSubtitle.height = 0
        tvSubtitle.isVisible = true
        val heightAnimator = ValueAnimator.ofInt(0, subtitleHeight)
        heightAnimator.addUpdateListener {
            tvSubtitle.height = it.animatedValue as Int
        }
        heightAnimator.start()
    }
}