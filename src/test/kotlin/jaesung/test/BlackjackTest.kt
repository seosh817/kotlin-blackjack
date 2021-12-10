package jaesung.test

import jaesung.state.Blackjack
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BlackjackTest {

    @Test
    fun profit() {
        val blackjack = Blackjack()
        val profit = blackjack.profit(1000.0)
        assertThat(profit).isEqualTo(1500.0)
    }
}
