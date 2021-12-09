package jaesung

class Hands(val values: List<PlayingCard>) {

    fun score(): Int {
        // 점수계산
        var sum = values.sumOf { it.score }
        val countOfAce = values.count { it.isAce }
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

    companion object {
        private const val PLUS_SCORE: Int = 10
        private const val BLACK_JACK_SCORE: Int = 21
    }
}
