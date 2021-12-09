package jaesung.test

import jaesung.CLUBS_ACE
import jaesung.CLUBS_KING
import jaesung.CLUBS_TEN
import jaesung.CLUBS_TWO
import jaesung.state.Bust
import jaesung.state.Hit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HitTest {
    @Test
    fun bust() {
        val hit = Hit(CLUBS_TEN, CLUBS_TWO)
        val state = hit.draw(CLUBS_KING)
        assertThat(state).isInstanceOf(Bust::class.java)
    }

    @Test
    fun hit() {
        val hit = Hit(CLUBS_TEN, CLUBS_TWO)
        val state = hit.draw(CLUBS_ACE)
        assertThat(state).isInstanceOf(Hit::class.java)
    }
}
