package com.github.luismendes070.tictactoegame

// import java.util.regex.Pattern.matches
// import androidx.core.content.MimeTypeFilter.matches

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
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
