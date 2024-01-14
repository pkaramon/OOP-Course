fun <T> Map<Vector2d, T>.randomPosition(): Vector2d? {
    val positions = this.keys.toList()
    return positions.randomOrNull()
}

fun <T>Map<Vector2d, T>.randomFreePosition(mapSize: Vector2d): Vector2d? {
    val freePositions = (0..<mapSize.x).flatMap { x ->
        (0..<mapSize.y).map { y -> Vector2d(x, y) }
    }.filterNot { it in this.keys }


    return freePositions.randomOrNull()
}

