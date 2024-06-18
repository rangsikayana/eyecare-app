package com.submission.eyecare.ui.custom

import android.content.Context
import android.graphics.Canvas
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Patterns
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import com.submission.eyecare.R

class CustomMail: AppCompatEditText, View.OnFocusChangeListener {

    private lateinit var same: String
    private var isMailTaken = false
    var isValid = false

    constructor(context: Context) : super(context) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initialize()
    }

    override fun onFocusChange(view: View?, focus: Boolean) {
        if (!focus) {
            isValid = Patterns.EMAIL_ADDRESS.matcher(text.toString().trim()).matches()
            error = if (!isValid) resources.getString(R.string.Format) else null
            if (isMailTaken) {
                error = if (isMailTaken && text.toString().trim() == same)
                    resources.getString(R.string.Taken) else null
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
      /*  hint = "Input User Email"*/
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun initialize() {
        inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        onFocusChangeListener = this
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                isValid = Patterns.EMAIL_ADDRESS.matcher(text.toString().trim()).matches()
                error = if (!isValid) resources.getString(R.string.Format) else null
                if (isMailTaken) {
                    error = if (isMailTaken && text.toString().trim() == same)
                        resources.getString(R.string.Taken) else null
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}