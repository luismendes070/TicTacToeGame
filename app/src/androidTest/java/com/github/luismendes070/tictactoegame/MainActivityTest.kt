package com.github.luismendes070.tictactoegame


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.github.luismendes070.tictactoegame.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val textView = onView(
            allOf(
                withId(com.google.android.apps.nexuslauncher.R.id.icon),
                withText("TicTacToeGame"),
                withContentDescription("TicTacToeGame"),
                withParent(
                    allOf(
                        withId(com.google.android.apps.nexuslauncher.R.id.apps_list_view),
                        withParent(withId(com.google.android.apps.nexuslauncher.R.id.apps_view))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("TicTacToeGame")))

        val textView2 = onView(
            allOf(
                withId(com.google.android.apps.nexuslauncher.R.id.icon),
                withText("TicTacToeGame"),
                withContentDescription("TicTacToeGame"),
                withParent(
                    allOf(
                        withId(com.google.android.apps.nexuslauncher.R.id.apps_list_view),
                        withParent(withId(com.google.android.apps.nexuslauncher.R.id.apps_view))
                    )
                ),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("TicTacToeGame")))
    }
}
