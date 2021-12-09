package jaesung.state

import jaesung.PlayingCard

class StateFactory {

    companion object {
        private const val PLUS_SCORE: Int = 10
        private const val BLACK_JACK_SCORE: Int = 21

        fun draw(card1: PlayingCard, card2: PlayingCard): State {
            val cards = listOf(card1, card2)
            val score = cards.score()
            // 점수계산에 따라서 실제 상태를 생성
            if (score < BLACK_JACK_SCORE) {
                return Hit(card1, card2)
            }
            return Blackjack()
        }

        private fun List<PlayingCard>.score(): Int {
            // 점수계산
            var sum = this.sumOf { it.score }
            val countOfAce = this.count { it.isAce }
            repeat(countOfAce) {
                sum = plusScoreIfNotBust(sum)
            }
            return sum
        }

        private fun plusScoreIfNotBust(score: Int): Int {
            if (isBust(score + PLUS_SCORE)) {
                return score
            }
            return score + PLUS_SCORE
        }

        private fun isBust(score: Int): Boolean = score > BLACK_JACK_SCORE
    }
}
