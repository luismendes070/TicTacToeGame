package com.github.luismendes070.tictactoegame.ui.board



// BingChat
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.graphics.Color
// import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

// Bard
// import androidx.compose.material.MaterialTheme
// import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
// import androidx.compose.material3.Color
import androidx.compose.material3.Icon
// Bard
/*import androidx.compose.material3.icons.M3Icons
import androidx.compose.material3.icons.M3Icons.Cross
import androidx.compose.material3.icons.M3Icons.RadioButtonUnchecked
import androidx.compose.material3.icons.M3Icons.Remove
import androidx.compose.material3.icons.M3Icons.Zero
import androidx.compose.material3.icons.M3Icons.X
import androidx.compose.material3.surface
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.LocalTextStyle.currentDensity
import androidx.compose.material3.LocalTextStyle.currentScale
import androidx.compose.material3.LocalTextStyle.currentTransform
import androidx.compose.material3.LocalTextStyle.currentWidth
import androidx.compose.material3.icons.Icon
import androidx.compose.material3.icons.m3Icon
import androidx.compose.material3.Icon
import androidx.compose.material3.icons.M3Icons
import androidx.compose.material3.icons.m3Icon*/
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
/*import androidx.compose.material3.Surface
import androidx.compose.material3.icons.M3Icons
import androidx.compose.material3.icons.m3Icon*/
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
/*import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalDensity.currentDensity
import androidx.compose.ui.platform.LocalDensity.currentScale
import androidx.compose.ui.platform.LocalDensity.currentTransform
import androidx.compose.ui.platform.LocalDensity.currentWidth*/
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.luismendes070.tictactoegame.logic.TicTacToeGame
import kotlin.math.roundToInt

enum class Player { X, O, EMPTY }

@Preview
@Composable
@Throws(Exception::class)
fun LazyVerticalGridExample(cells: List<Player>, onCellClick: (Int) -> Unit) {
    val rows = 3
    val columns = 3

    val lazyVerticalGrid: TicTacToeGame = createLazyVerticalGrid(
        rowCount = 3,
        columnCount = 3,
        itemHeight = 100.dp,
        itemWidth = 100.dp
    )
}

fun createLazyVerticalGrid(
    rowCount: Int,
    columnCount: Int,
    itemHeight: Dp,
    itemWidth: Dp
): LazyVerticalGrid {
    return LazyVerticalGrid(
        rowCount = rowCount,
        columnCount = columnCount,
        itemHeight = itemHeight,
        itemWidth = itemWidth
    )
}



@Composable
fun GridCell(player: Player, onCellClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clickable(onClick = onCellClick)
            .background(Color.Gray)
    ) {
        try {
            when (player) {
                Player.X -> Icon(m3Icon(M3Icons.X), contentDescription = null)
                Player.O -> Icon(m3Icon(M3Icons.Zero), contentDescription = null)
                Player.EMPTY -> { /* No icon */}
            }
        } catch (e: Exception) {
            // Handle the exception here
            e.printStackTrace()
        }
    }
}




@Composable
fun TicTacToeGame() {
    var cells by remember { mutableStateOf(List(9) { Player.EMPTY }) }
    var currentPlayer by remember { mutableStateOf(Player.X) }

    fun handleCellClick(index: Int) {
        if (cells[index] == Player.EMPTY) {
            cells = cells.toMutableList().also {
                it[index] = currentPlayer
            }
            currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TicTacToeGrid(cells, onCellClick = { handleCellClick(it) })
        }
    }
}

@Composable
fun TicTacToeApp() {
    MaterialTheme {
        TicTacToeGame()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTicTacToeApp() {
    TicTacToeApp()
}
