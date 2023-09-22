package com.github.luismendes070.tictactoegame
// Bard
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.test.junit4.AndroidTestRule
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.unit.dp
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.github.luismendes070.tictactoegame.logic.TicTacToeGame
import com.github.luismendes070.tictactoegame.ui.MainActivity
// import com.example.lazyverticalgrid.LazyVerticalGrid
import com.github.luismendes070.tictactoegame.ui.board.TicTacToeGame
import com.github.luismendes070.tictactoegame.ui.board.createLazyVerticalGrid
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


// @RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
@RunWith(JUnitPlatform::class) // JUnit 5

class LazyVerticalGridInstrumentedTest {

    @get:Rule
    val composeTestRule = ComposeTestRule()

    fun testWin() {
        // Launch the activity under test.
        // launchActivity<MainActivity>()

        // Click on the grid items to create the winning pattern.
        onView(withId(R.id.grid_item_11)).perform(click())
        onView(withId(R.id.grid_item_22)).perform(click())
        onView(withId(R.id.grid_item_33)).perform(click())

        // Check if the game is won.
        onView(withId(R.id.text_view_winner)).check(matches(isDisplayed()))
        onView(withId(R.id.text_view_winner)).check(matches(withText("X")))
    }

    @Test
    fun testLazyVerticalGrid() {

        val lazyVerticalGrid: TicTacToeGame = createLazyVerticalGrid(
            rowCount = 3,
            columnCount = 3,
            itemHeight = 100.dp,
            itemWidth = 100.dp
        )

        // Create a new instance of the LazyVerticalGrid class.
/*        val lazyVerticalGrid: TicTacToeGame = LazyVerticalGrid(
            rowCount = 3,
            columnCount = 3,
            itemHeight = 100.dp,
            itemWidth = 100.dp
        )*/

        // Set the values of the LazyVerticalGrid class.
        lazyVerticalGrid.items = listOf("X", "O", "X", "O", "X", "O", "X", "O", "X")

        // Call the method that you want to test.
        lazyVerticalGrid.scrollTo(x = 0.dp, y = 0.dp)

        // Assert that the result of the method call is as expected.
        assertEquals(0.dp, lazyVerticalGrid.scrollX)
        assertEquals(0.dp, lazyVerticalGrid.scrollY)
    }
}

