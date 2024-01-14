enum class MapDirection(private val string: String, val indicator: String) {
    NORTH("Północ", "^"),
    EAST("Wschód", ">"),
    SOUTH("Południe", "v"),
    WEST("Zachód", "<",);

    fun next() = entries[(ordinal + 1) % entries.size]
    fun previous() = entries[(ordinal - 1 + entries.size) % entries.size]

    override fun toString() = string
}