package com.github.luismendes070.tictactoegame.ui.board

import androidx.compose.ui.graphics.Color
// import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid

// Bard
// import androidx.compose.material.MaterialTheme
// import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
// import androidx.compose.material3.Color
import androidx.compose.material3.Icon
// Bard
import androidx.compose.material3.icons.M3Icons
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
import androidx.compose.material3.icons.m3Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.icons.M3Icons
import androidx.compose.material3.icons.m3Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalDensity.currentDensity
import androidx.compose.ui.platform.LocalDensity.currentScale
import androidx.compose.ui.platform.LocalDensity.currentTransform
import androidx.compose.ui.platform.LocalDensity.currentWidth
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

enum class Player { X, O, EMPTY }

@Composable
fun TicTacToeGrid(cells: List<Player>, onCellClick: (Int) -> Unit) {
    LazyVerticalGrid(
        cells = cells,
        cellContent = { player, index ->
            GridCell(player) {
                onCellClick(index)
            }
        },
        cellsInRow = 3
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
        when (player) {
            Player.X -> Icon(m3Icon(M3Icons.X), contentDescription = null)
            Player.O -> Icon(m3Icon(M3Icons.Zero), contentDescription = null)
            Player.EMPTY -> { /* No icon */}
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
