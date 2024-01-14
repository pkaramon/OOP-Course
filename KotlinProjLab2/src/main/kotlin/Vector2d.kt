data class Vector2d(val x: Int, val y: Int) {

    fun precedes(other: Vector2d): Boolean = this.x <= other.x && this.y <= other.y

    fun follows(other: Vector2d): Boolean = this.x >= other.x && this.y >= other.y

    fun add(other: Vector2d): Vector2d = Vector2d(this.x + other.x, this.y + other.y)

    fun subtract(other: Vector2d): Vector2d = Vector2d(this.x - other.x, this.y - other.y)

    fun upperRight(other: Vector2d): Vector2d = Vector2d(maxOf(this.x, other.x), maxOf(this.y, other.y))

    fun lowerLeft(other: Vector2d): Vector2d = Vector2d(minOf(this.x, other.x), minOf(this.y, other.y))

    fun opposite(): Vector2d = Vector2d(-this.x, -this.y)

    override fun toString(): String = "($x,$y)"
}
