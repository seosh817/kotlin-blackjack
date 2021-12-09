package jaesung

class PlayingCard private constructor(private val suit: Suit, private val denomination: Denomination) {
    val isAce: Boolean = denomination.isAce
    val score: Int = denomination.score

    companion object {
        private val CARDS: MutableMap<String, PlayingCard> = mutableMapOf()

        fun of(suit: Suit, denomination: Denomination): PlayingCard {
            return CARDS[toKey(suit, denomination)] ?: throw NoSuchElementException()
        }

        private fun toKey(suit: Suit, denomination: Denomination): String {
            return suit.name + denomination.name
        }

        init {
            for (suit in Suit.values()) {
                for (denomination in Denomination.values()) {
                    CARDS[toKey(suit, denomination)] = PlayingCard(suit, denomination)
                }
            }
        }
    }
}
