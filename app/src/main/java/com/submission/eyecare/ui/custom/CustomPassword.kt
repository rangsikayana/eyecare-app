package com.submission.eyecare.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class CustomPassword: AppCompatEditText {

    var isValid = false

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
                isValid = (text?.length ?: 0) >= 8
                if (!isValid) {
                    setError("Password Minimum is 8 Characters", null)
                } else {
                    error = null
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}