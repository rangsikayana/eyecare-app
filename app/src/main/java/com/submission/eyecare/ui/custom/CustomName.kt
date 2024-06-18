package com.submission.eyecare.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import com.submission.eyecare.R

class CustomName : AppCompatEditText {
    private var  isValid = false

    constructor(context: Context): super(context) {initialize()}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {initialize()}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context,attrs, defStyleAttr) {initialize()}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun initialize() {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                isValid = text.toString().trim().isNotEmpty()
                error = if(!isValid){
                    resources.getString(R.string.Empty)
                } else {
                    null
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}