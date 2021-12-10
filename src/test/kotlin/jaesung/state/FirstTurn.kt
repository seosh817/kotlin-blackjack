package jaesung.state

import jaesung.Hands
import jaesung.PlayingCard

class FirstTurn : Running() {

    fun draw(card1: PlayingCard, card2: PlayingCard): State {
        val hands = Hands(listOf(card1, card2))
        if (hands.isBlackjack) {
            return Blackjack()
        }
        return Hit(card1, card2)
    }
}
