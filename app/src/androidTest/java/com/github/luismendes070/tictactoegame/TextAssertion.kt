package com.github.luismendes070.tictactoegame

// import android.view.View
// import androidx.test.espresso.NoMatchingViewException
// import androidx.test.espresso.ViewAssertion

// Bard
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.NoMatchingViewException
import android.view.View

class TextAssertion : ViewAssertion {
    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        // Verify that the text of the view matches the specified text
        val expectedText = "Clicked!"
        val actualText = view.toString()
        if (expectedText != actualText) {
            throw AssertionError("Expected text '$expectedText', but found text '$actualText'")
        }
    }
}


