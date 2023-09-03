package com.github.luismendes070.tictactoegame

// ChatGPT
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ButtonClickInstrumentedTest {

    // Launch the activity before running the tests
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testButtonClick() {
        // Find the button by its ID and perform a click action
        Espresso.onView(withId(R.id.buttonClickMe)).perform(click())

        // Verify that the expected text appears on the screen
        Espresso.onView(withId(R.id.textViewResult)).check(matches(withText("Clicked!")))
    }
}
