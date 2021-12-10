package jaesung.test

import jaesung.CLUBS_ACE
import jaesung.CLUBS_KING
import jaesung.CLUBS_TEN
import jaesung.state.Blackjack
import jaesung.state.Hit
import jaesung.state.State
import jaesung.state.FirstTurn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FirstTurnTest {

    @Test
    fun blackjack() {
        val state = FirstTurn().draw(CLUBS_ACE, CLUBS_KING)
        assertThat(state).isInstanceOf(Blackjack::class.java)
    }

    @Test
    fun hit() {
        val state: State = FirstTurn().draw(CLUBS_TEN, CLUBS_KING)
        assertThat(state).isInstanceOf(Hit::class.java)
    }
}
