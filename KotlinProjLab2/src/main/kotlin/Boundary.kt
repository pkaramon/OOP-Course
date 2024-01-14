data class Boundary(val lowerLeft: Vector2d, val upperRight: Vector2d) {
    fun height(): Int = upperRight.y - lowerLeft.y + 1
    fun width(): Int = upperRight.x - lowerLeft.x + 1
}
