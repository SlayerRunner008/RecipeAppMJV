package com.pjasoft.recipeapp.domain.utils

import androidx.compose.ui.focus.FocusManager
import platform.UIKit.UIApplication
import platform.UIKit.endEditing

actual fun hideKeyboard(focusManager: FocusManager) {
    UIApplication.sharedApplication.keyWindow?.endEditing(true)
}