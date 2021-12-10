package jaesung.state

interface State {
    fun isFinished(): Boolean
    fun profit(money: Double): Double
}
