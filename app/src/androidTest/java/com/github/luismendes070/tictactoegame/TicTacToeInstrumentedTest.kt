package com.github.luismendes070.tictactoegame

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.luismendes070.tictactoegame.logic.TicTacToeGame
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TicTacToeInstrumentedTest {

    @Test
    fun testXWins() {
        val game = TicTacToeGame()
        game.makeMove(0, 0, 'X')
        game.makeMove(1, 1, 'O')
        game.makeMove(0, 1, 'X')
        game.makeMove(1, 2, 'O')
        game.makeMove(0, 2, 'X')
        assertTrue(game.checkWin('X'))
        assertFalse(game.checkWin('O'))
    }

    @Test
    fun testOWins() {
        val game = TicTacToeGame()
        game.makeMove(0, 0, 'X')
        game.makeMove(1, 1, 'O')
        game.makeMove(0, 1, 'X')
        game.makeMove(1, 2, 'O')
        game.makeMove(2, 2, 'X')
        game.makeMove(2, 0, 'O')
        assertTrue(game.checkWin('O'))
        assertFalse(game.checkWin('X'))
    }
}
