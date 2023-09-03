package com.github.luismendes070.tictactoegame

import android.view.View
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion

// Bard
class TextAssertion : ViewAssertion {

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        // Verify that the text of the view matches the specified text
        val expectedText = "Clicked!"
        val actualText = view.text
        if (expectedText != actualText) {
            throw AssertionError("Expected text '$expectedText', but found text '$actualText'")
        }
    }
}
