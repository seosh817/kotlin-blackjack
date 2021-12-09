package jaesung.state

import jaesung.PlayingCard

class StateFactory {

    companion object {
        private const val PLUS_SCORE: Int = 10
        private const val BLACK_JACK_SCORE: Int = 21

        fun draw(card1: PlayingCard, card2: PlayingCard): State {

            val cards = listOf(card1, card2)
            var sum = cards.sumOf { it.score }
            val countOfAce = cards.count { it.isAce }
            repeat(countOfAce) {
                sum = plusScoreIfNotBust(sum)
            }
            if (sum < BLACK_JACK_SCORE) {
                return Hit()
            }
            return Blackjack()
        }

        private fun plusScoreIfNotBust(sum: Int): Int {
            if (isBust(sum)) {
                return sum
            }
            return sum + PLUS_SCORE
        }

        private fun isBust(score: Int): Boolean = score + PLUS_SCORE > BLACK_JACK_SCORE
    }
}
