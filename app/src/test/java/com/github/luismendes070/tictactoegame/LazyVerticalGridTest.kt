package com.github.luismendes070.tictactoegame

// Bard
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.unit.dp
import com.example.lazyverticalgrid.LazyVerticalGrid
import org.junit.Rule
import org.junit.Test

class LazyVerticalGridTest {

    @get:Rule
    val composeTestRule = ComposeTestRule()

    @Test
    fun testLazyVerticalGrid() {
        // Create a new instance of the LazyVerticalGrid class.
        val lazyVerticalGrid = LazyVerticalGrid(
            rowCount = 3,
            columnCount = 3,
            itemHeight = 100.dp,
            itemWidth = 100.dp
        )

        // Set the values of the LazyVerticalGrid class.
        lazyVerticalGrid.items = listOf("X", "O", "X", "O", "X", "O", "X", "O", "X")

        // Call the method that you want to test.
        lazyVerticalGrid.scrollTo(x = 0.dp, y = 0.dp)

        // Assert that the result of the method call is as expected.
        assertEquals(0.dp, lazyVerticalGrid.scrollX)
        assertEquals(0.dp, lazyVerticalGrid.scrollY)
    }
}

