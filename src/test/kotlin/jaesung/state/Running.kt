package jaesung.state

abstract class Running : State {

    override fun isFinished(): Boolean = false

    override fun profit(money: Double): Double {
        throw UnsupportedOperationException()
    }
}
