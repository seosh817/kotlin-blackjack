package jaesung

class Hands(val values: List<PlayingCard>) {
    val isBust: Boolean
        get() = score().isBust
    val isBlackjack: Boolean
        get() = score().isBlackjack

    fun score(): Score {
        // 점수계산
        var sum = Score(values.sumOf { it.score })
        val countOfAce = values.count { it.isAce }
        repeat(countOfAce) {
            sum = sum.plusScoreIfNotBust()
        }
        return sum
    }
}
