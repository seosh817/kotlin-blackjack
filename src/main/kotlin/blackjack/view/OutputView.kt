package blackjack.view

import blackjack.domain.Dealer
import blackjack.domain.Name
import blackjack.domain.Player
import blackjack.domain.Players

object OutputView {

    private const val SEPARATOR = ", "
    private const val DEALER_MESSAGE = "%s와 "
    private const val DRAW_MESSAGE = "%s에게 2장을 나누었습니다."
    private const val DEALER_DRAW_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다."
    private const val PLAYER_CARD_OUTPUT_MESSAGE = "%s 카드: %s"
    private const val PLAYER_SCORE_OUTPUT_MESSAGE = "결과: %s"
    private const val FINAL_RESULT_MESSAGE = "## 최종 수익"
    private const val DEALER_RESULT_MESSAGE = "딜러: %s"

    fun printHowManyCardsPlayerDrawn(dealer: Dealer, players: Players) {
        val output = buildString {
            append(System.lineSeparator())
            append(DEALER_MESSAGE.format(dealer.name.name))
            append(DRAW_MESSAGE.format(players.players.joinToString(SEPARATOR) { it.name.name }))
        }
        println(output)
    }

    fun printPlayersDrawnCards(dealer: Dealer, players: Players) {
        val output = buildString {
            append(dealer.printPlayerDrawn())
            players.players.forEach { player ->
                append(player.printPlayerDrawn())
            }
        }
        println(output)
    }

    fun printPlayerDrawnCard(player: Player) {
        val output = buildString {
            append("${player.name.name}카드: ")
            append(player.cardToString())
        }
        println(output)
    }

    fun printDealerDraw() {
        println()
        println(DEALER_DRAW_MESSAGE)
    }

    fun printScoreResult(dealer: Dealer, players: Players) {
        val output = buildString {
            append(System.lineSeparator())
            append(
                PLAYER_CARD_OUTPUT_MESSAGE.format(
                    dealer.name.name,
                    dealer.cardToString()
                )
            )
            append(" - ")
            append(PLAYER_SCORE_OUTPUT_MESSAGE.format(dealer.score.score))
            append(System.lineSeparator())
            players.players.forEach {
                append(
                    PLAYER_CARD_OUTPUT_MESSAGE.format(
                        it.name.name,
                        it.cardToString()
                    )
                )
                append(" - ")
                append(PLAYER_SCORE_OUTPUT_MESSAGE.format(it.score.score))
                append(System.lineSeparator())
            }
        }
        println(output)
    }

    fun printDealerResult(dealerProfit: Int) {
        val output = buildString {
            append(FINAL_RESULT_MESSAGE)
            append(System.lineSeparator())
            append(DEALER_RESULT_MESSAGE.format(dealerProfit))
        }
        println(output)
    }

    fun printPlayersResult(resultMap: Map<Name, Int>) {
        resultMap.entries.forEach { (name, result) ->
            println("${name.name}: $result")
        }
    }

    private fun Player.cardToString(): String {
        return cards.cards.joinToString { card -> "${card.denomination.displayName}${card.suitType.displayName}" }
    }

    private fun Player.printPlayerDrawn(): StringBuilder {
        return StringBuilder().apply {
            append("${name.name}카드: ")
            append(cardToString())
            append(System.lineSeparator())
        }
    }
}
