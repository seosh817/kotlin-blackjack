package blackjack.domain

import blackjack.controller.GameController.BLACK_JACK_SCORE

data class Score(val score: Int) {

    val isBust: Boolean = score > BLACK_JACK_SCORE

    init {
        require(score >= 0) { SCORE_MUST_BE_ZERO_OR_MORE_EXCEPTION_MESSAGE }
    }

    fun getAceScore(): Score =
        if (MAX_ACE_SCORE + score > BLACK_JACK_SCORE) {
            Score(MIN_ACE_SCORE)
        } else {
            Score(MAX_ACE_SCORE)
        }

    operator fun plus(other: Score) = Score(score + other.score)

    operator fun compareTo(other: Score) = score.compareTo(other.score)

    companion object {
        private const val MIN_ACE_SCORE = 1
        private const val MAX_ACE_SCORE = 11
        private const val SCORE_MUST_BE_ZERO_OR_MORE_EXCEPTION_MESSAGE = "점수는 0이상이어야 합니다."
    }
}