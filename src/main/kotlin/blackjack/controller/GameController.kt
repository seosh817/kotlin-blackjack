package blackjack.controller

import blackjack.domain.Dealer
import blackjack.domain.Money
import blackjack.domain.Player
import blackjack.domain.PlayerBettings
import blackjack.domain.Players
import blackjack.domain.card.CardDeck
import blackjack.domain.strategy.draw.DrawStrategy
import blackjack.domain.strategy.draw.HitDrawStrategy
import blackjack.domain.strategy.draw.InitialDrawStrategy
import blackjack.view.InputView
import blackjack.view.OutputView

object GameController {

    private val cardDeck = CardDeck()

    fun start() {
        var dealer = Dealer()
        val playerNames = InputView.inputPlayerNames()
        var players = Players.from(Players.getPlayerListByNames(playerNames))

        val playerBettings = players.askPlayersBettingMoney()

        dealer = dealer.draw(cardDeck, InitialDrawStrategy)
        players = players.drawCardEachPlayer(cardDeck, InitialDrawStrategy)

        OutputView.printHowManyCardsPlayerDrawn(dealer, players)
        OutputView.printPlayersDrawnCards(dealer, players)

        players = players.drawIfAskPlayerWantsToDraw(cardDeck, HitDrawStrategy)

        dealer = drawDealer(dealer, HitDrawStrategy)

        OutputView.printScoreResult(dealer, players)
        printDealerResults(dealer, players, playerBettings)
        printPlayersResults(dealer, players, playerBettings)
    }

    private fun Players.drawIfAskPlayerWantsToDraw(
        cardDeck: CardDeck,
        drawStrategy: DrawStrategy
    ): Players {
        return players
            .map {
                drawOrStay(it, cardDeck, drawStrategy)
            }
            .let { Players.from(it) }
    }

    private fun drawOrStay(
        player: Player,
        cardDeck: CardDeck,
        drawStrategy: DrawStrategy
    ): Player {
        var nowPlayer = player
        while (!nowPlayer.isFinished) {
            nowPlayer = askDrawOrStay(nowPlayer, cardDeck, drawStrategy)
        }
        return nowPlayer
    }

    private fun askDrawOrStay(
        player: Player,
        cardDeck: CardDeck,
        drawStrategy: DrawStrategy
    ): Player {
        if (InputView.askPlayerWantsToDraw(player)) {
            return player.draw(cardDeck, drawStrategy).also {
                OutputView.printPlayerDrawnCard(it)
            }
        }
        return player.stay()
    }

    private fun drawDealer(dealer: Dealer, drawStrategy: DrawStrategy): Dealer {
        if (dealer.canHit()) {
            OutputView.printDealerDraw()
            return dealer.draw(cardDeck, drawStrategy)
        }
        return dealer.stay()
    }

    private fun printDealerResults(dealer: Dealer, players: Players, bettings: PlayerBettings) {
        val dealerProfit = bettings.calculateDealerProfit(dealer, players)
        OutputView.printDealerResult(dealerProfit)
    }

    private fun printPlayersResults(dealer: Dealer, players: Players, playerBettings: PlayerBettings) {
        val result = playerBettings.calculatePlayersProfit(dealer, players)
        OutputView.printPlayersResult(result)
    }

    private fun Players.askPlayersBettingMoney(): PlayerBettings {
        return players
            .associate { it.name to Money.from(InputView.askPlayerBetMoney(it)) }
            .let { PlayerBettings.from(it) }
    }
}
