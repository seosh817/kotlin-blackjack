package blackjack.domain

class BlackJackManager(
    private val players: Players
) {

    fun giveInitialCards(cardDeck: CardDeck) {
        repeat(2) {
            players.eachAcceptCards(cardDeck)
        }
    }

    fun hitPlayer(question: (Player) -> String, cardDeck: CardDeck, printResult: ((Player) -> Unit)? = null) {
        players.forEach { player ->
            while (question(player) == "y" && player.canHit()) {
                player.hit(cardDeck.next())
                printResult?.invoke(player)
            }
        }
    }
}