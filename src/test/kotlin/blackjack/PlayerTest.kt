package blackjack

import blackjack.domain.Card
import blackjack.domain.NumberType
import blackjack.domain.Player
import blackjack.domain.SuitType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PlayerTest {

    @DisplayName(value = "player의 score가 21점 미만이면 카드를 추가할 수 있다(hit())")
    @Test
    fun `player의 score가 21점 미만이면 카드를 추가할 수 있다(hit())`() {
        val player = Player.of("seunghwan")
        val card1 = Card.of(SuitType.SPADE, NumberType.TEN)
        val card2 = Card.of(SuitType.SPADE, NumberType.TEN)
        val card3 = Card.of(SuitType.SPADE, NumberType.TWO)

        player.hit(card1)
        player.hit(card2)
        player.hit(card3)

        assertThat(player.cards).containsExactlyElementsOf(listOf(Card.of(SuitType.SPADE, NumberType.TEN), Card.of(SuitType.SPADE, NumberType.TEN), Card.of(SuitType.SPADE, NumberType.TWO)))
    }

    @DisplayName(value = "player의 score가 21점 이상이면 카드를 추가할 수 없다(canHit())")
    @Test
    fun `player의 score가 21점 이상이면 카드를 추가할 수 없다(canHit())`() {
        val player = Player.of("seunghwan")
        val card1 = Card.of(SuitType.SPADE, NumberType.TEN)
        val card2 = Card.of(SuitType.SPADE, NumberType.TEN)
        val card3 = Card.of(SuitType.SPADE, NumberType.TWO)

        player.hit(card1)
        assertThat(player.canHit()).isTrue

        player.hit(card2)
        assertThat(player.canHit()).isTrue

        player.hit(card3)
        assertThat(player.canHit()).isFalse
    }

    @DisplayName(value = "player는 가지고있는 카드들의 점수를 알고있다.(nowScore())")
    @Test
    fun `player는 가지고있는 카드들의 점수를 알고있다(nowScore())`() {
        val player = Player.of("seunghwan")
        val card1 = Card.of(SuitType.SPADE, NumberType.ACE)
        val card2 = Card.of(SuitType.SPADE, NumberType.ACE)
        val card3 = Card.of(SuitType.SPADE, NumberType.ACE)

        player.hit(card1)
        player.hit(card2)
        player.hit(card3)
        assertThat(player.nowScore()).isEqualTo(13)
    }
}