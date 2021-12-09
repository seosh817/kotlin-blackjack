package jaesung.state

import jaesung.PlayingCard

class Hit(
    private val card1: PlayingCard,
    private val card2: PlayingCard
) : State {
    fun draw(card3: PlayingCard): State {
        val cards = listOf(card1, card2, card3)
        var sum = cards.sumOf { it.score }
        val countOfAce = cards.count { it.isAce }
        repeat(countOfAce) {
            sum = plusScoreIfNotBust(sum)
        }

        if (sum < BLACK_JACK_SCORE) {
            return Hit(card1, card2)
        }

        return Bust()
    }

    private fun plusScoreIfNotBust(score: Int): Int {
        if (isBust(score + PLUS_SCORE)) {
            return score
        }
        return score + PLUS_SCORE
    }

    private fun isBust(score: Int): Boolean = score > BLACK_JACK_SCORE

    companion object {
        private const val PLUS_SCORE: Int = 10
        private const val BLACK_JACK_SCORE: Int = 21
    }
}
