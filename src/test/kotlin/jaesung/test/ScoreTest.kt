package jaesung.test

import jaesung.Score
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScoreTest {

    // 버스트가 아닌 경우에만 10점을 더하기 때문에 20
    @Test
    fun plusScoreIfNotBust() {
        val score = Score(20)
        val actual = score.plusScoreIfNotBust()
        assertThat(actual).isEqualTo(Score(20))
    }

    // 10점일 때는 10점을 더해도 21점을 넘지 않기 때문에 테스트 통과.
    @Test
    fun plusScoreIfNotBust2() {
        val score = Score(10)
        val actual = score.plusScoreIfNotBust()
        assertThat(actual).isEqualTo(Score(20))
    }
}
