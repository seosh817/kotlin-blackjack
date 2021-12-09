package jaesung.test

import jaesung.CLUBS_ACE
import jaesung.CLUBS_KING
import jaesung.CLUBS_TEN
import jaesung.Hands
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HandsTest {

    @Test
    fun score() {
        val hands = Hands(listOf(CLUBS_TEN, CLUBS_KING))
        val score = hands.score()
        assertThat(score).isEqualTo(20)
    }

    @Test
    fun score2() {
        val hands = Hands(listOf(CLUBS_TEN, CLUBS_ACE))
        val score = hands.score()
        assertThat(score).isEqualTo(21)
    }
}
