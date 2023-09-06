package com.github.luismendes070.tictactoegame

// Bard
// import TextAssertion
// import androidx.test.espresso.assertion.ViewAssertion

// ChatGPT
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ButtonClickInstrumentedTest {

    // Launch the activity before running the tests
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testButtonClick() {
        // Find the button by its ID and perform a click action
        Espresso.onView(withId(R.id.btnPlay)).perform(click())

        // Verify that the expected text appears on the screen
        // Espresso.onView(withId(R.id.button)).check(matches(withText("Clicked!")))
        // val assertion = (ViewAssertion) TextAssertion(expectedText = "Clicked!")
        // Espresso.onView(withId(R.id.button)).check(assertion)
        // fail()
        // Inside your Espresso test, use the custom TextAssertion
        Espresso.onView(withId(R.id.btnPlay))
            .check(TextAssertion())
    }
}
