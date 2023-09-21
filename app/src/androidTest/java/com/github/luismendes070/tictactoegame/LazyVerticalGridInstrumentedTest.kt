package com.github.luismendes070.tictactoegame
// Bard
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.test.junit4.AndroidTestRule
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.unit.dp
import com.github.luismendes070.tictactoegame.logic.TicTacToeGame
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

