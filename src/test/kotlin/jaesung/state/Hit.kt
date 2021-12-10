package jaesung.state

import jaesung.Hands
import jaesung.PlayingCard

class Hit(
    private val card1: PlayingCard,
    private val card2: PlayingCard
) : State {

    override fun isFinished(): Boolean = false

    override fun profit(money: Double): Double {
        throw UnsupportedOperationException()
    }

    fun draw(card3: PlayingCard): State {
        val hands = Hands(listOf(card1, card2, card3))
        if (hands.isBust) {
            return Bust()
        }
        return Hit(card1, card2)
    }

    fun stay(): State {
        return Stay()
    }
}
