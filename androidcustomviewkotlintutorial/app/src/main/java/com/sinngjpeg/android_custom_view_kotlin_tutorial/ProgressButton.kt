package com.sinngjpeg.android_custom_view_kotlin_tutorial

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.sinngjpeg.android_custom_view_kotlin_tutorial.databinding.ProgressButtonBinding

class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var title: String? = null
    private var loadingTitle: String? = null

    private val binding = ProgressButtonBinding
        .inflate(LayoutInflater.from(context), this, true)

    init {
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ProgressButton
            )
            setBackgroundColor(R.drawable.progress_button_background)
            val titleResId =
                attributes.getResourceId(R.styleable.ProgressButton_progress_button_title, 0)
            if (titleResId != 0) {
                title = context.getString(titleResId)
            }

            val loadingTitleResId =
                attributes.getResourceId(
                    R.styleable.ProgressButton_progress_button_loading_title,
                    0
                )
            if (loadingTitleResId != 0) {
                loadingTitle = context.getString(loadingTitleResId)
            }
            attributes.recycle()
        }
    }
}
