package jaesung.state

abstract class Finished : State {
    abstract val earningRate: Double
    override fun isFinished(): Boolean = true
    override fun profit(money: Double): Double {
        return money * earningRate
    }
}
