package com.github.luismendes070.tictactoegame

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test

// Bard
class MyActivityTest : AndroidJUnit4() {

    @Test
    fun testButtonClick() {
        // Find the button in the layout
        val button = onView(withId(R.id.button))

        // Click the button
        button.perform(click())

        // Verify that the text of the button changes
        onView(withText("Clicked!")).check(matches(isDisplayed()))
    }
}
