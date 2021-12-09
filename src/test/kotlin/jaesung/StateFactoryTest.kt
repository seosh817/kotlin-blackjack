package jaesung

import jaesung.state.Blackjack
import jaesung.state.Hit
import jaesung.state.State
import jaesung.state.StateFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StateFactoryTest {

    @Test
    fun blackjack() {
        val state = StateFactory.draw(CLUBS_ACE, CLUBS_KING)
        assertThat(state).isInstanceOf(Blackjack::class.java)
    }

    @Test
    fun hit() {
        val state: State = StateFactory.draw(CLUBS_TEN, CLUBS_KING)
        assertThat(state).isInstanceOf(Hit::class.java)
    }
}
