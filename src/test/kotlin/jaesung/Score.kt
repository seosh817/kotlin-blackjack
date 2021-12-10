package jaesung

data class Score(val value: Int) {
    val isBust: Boolean = value > BLACK_JACK_SCORE
    val isBlackjack: Boolean = value == BLACK_JACK_SCORE

    fun plusScoreIfNotBust(): Score {
        val score = Score(value + PLUS_SCORE)
        if (score.isBust) {
            return this
        }
        return score
    }

    companion object {
        private const val PLUS_SCORE: Int = 10
        private const val BLACK_JACK_SCORE: Int = 21
    }
}
