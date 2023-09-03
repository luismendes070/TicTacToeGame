package com.github.luismendes070.tictactoegame

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

// Bard
@RunWith(AndroidJUnit4::class)
class MyActivityTest {

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
