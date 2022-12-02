package day02

enum class HandShape(
    val opponentCode: String,
    val playerCode: String,
    val points: Int,
) {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);


    companion object {
        fun fromCode(code: String) = HandShape.values().first { it.opponentCode == code || it.playerCode == code }
    }
}