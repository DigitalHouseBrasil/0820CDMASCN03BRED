package com.github.cesar1287.desafiopicpayandroid.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.github.cesar1287.desafiopicpayandroid.extensions.unmask

class MaskWatcher(private var editText: EditText, private var mask: String) : TextWatcher {

    var isUpdating: Boolean = false
    var old = ""

    override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
    }

    override fun afterTextChanged(editable: Editable) {

    }

    override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {


        val string = charSequence.toString().unmask()
        var mask = ""
        if (isUpdating) {
            old = string
            isUpdating = false
            return
        }
        var index = 0
        for (item in this.mask.toCharArray()) {
            if (item != '#' && string.length > old.length) {
                mask += item
                continue
            }
            try {
                mask += string[index]
            } catch (exception: Exception) {
                break
            }

            index++
        }

        isUpdating = true
        editText.setText(mask)
        editText.setSelection(mask.length)
    }
}