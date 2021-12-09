package jaesung.test

import jaesung.Denomination
import jaesung.PlayingCard
import jaesung.Suit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PlayingCardTest {

    @Test
    fun same() {
        val card1 = PlayingCard.of(Suit.CLUBS, Denomination.ACE)
        val card2 = PlayingCard.of(Suit.CLUBS, Denomination.ACE)
        assertThat(card1).isSameAs(card2)
    }
}
