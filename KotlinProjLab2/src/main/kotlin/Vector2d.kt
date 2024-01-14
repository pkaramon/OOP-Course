data class Vector2d(val x: Int, val y: Int) {
    operator fun compareTo(other: Vector2d): Int {
        return if (x == other.x) y.compareTo(other.y) else x.compareTo(other.x)
    }

    operator fun plus(other: Vector2d): Vector2d = Vector2d(x + other.x, y + other.y)
    operator fun minus(other: Vector2d): Vector2d = Vector2d(x - other.x, y - other.y)


    fun upperRight(other: Vector2d): Vector2d = Vector2d(maxOf(this.x, other.x), maxOf(this.y, other.y))

    fun lowerLeft(other: Vector2d): Vector2d = Vector2d(minOf(this.x, other.x), minOf(this.y, other.y))

    operator fun unaryMinus(): Vector2d = Vector2d(-this.x, -this.y)

    override fun toString(): String = "($x,$y)"
}

fun MapDirection.toUnitVector() : Vector2d {
    return when(this) {
        MapDirection.NORTH -> Vector2d(0,1)
        MapDirection.EAST -> Vector2d(1,0)
        MapDirection.SOUTH -> Vector2d(0, -1)
        MapDirection.WEST -> Vector2d(-1, 0)
    }
}
