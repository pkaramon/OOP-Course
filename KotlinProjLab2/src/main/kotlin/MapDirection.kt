enum class MapDirection(private val string: String, val indicator: String, val unitVector: Vector2d) {
    NORTH("Północ", "^", Vector2d(0, 1)),
    EAST("Wschód", ">", Vector2d(1, 0)),
    SOUTH("Południe", "v", Vector2d(0, -1)),
    WEST("Zachód", "<", Vector2d(-1, 0));

    fun next() = entries[(ordinal + 1) % entries.size]
    fun previous() = entries[(ordinal - 1 + entries.size) % entries.size]

    override fun toString() = string
}