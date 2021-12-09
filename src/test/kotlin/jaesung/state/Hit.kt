package jaesung.state

import jaesung.Hands
import jaesung.PlayingCard

class Hit(
    private val card1: PlayingCard,
    private val card2: PlayingCard
) : State {

    fun draw(card3: PlayingCard): State {
        val cards = Hands(listOf(card1, card2, card3))
        val score = cards.score()

        if (score < BLACK_JACK_SCORE) {
            return Hit(card1, card2)
        }

        return Bust()
    }

    companion object {
        private const val BLACK_JACK_SCORE: Int = 21
    }
}
