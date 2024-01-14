class Animal(private var pos: Vector2d = Vector2d(0,0)) : WorldElement {
    var orientation: MapDirection = MapDirection.NORTH
    private set


    override var position: Vector2d
        get() = pos
        set(value) { pos = value }

    override fun toString(): String = orientation.indicator

    fun move(direction: MoveDirection, moveValidator: MoveValidator) {
        when (direction) {
            MoveDirection.RIGHT -> orientation = orientation.next()
            MoveDirection.LEFT -> orientation = orientation.previous()
            MoveDirection.FORWARD -> setPosition(pos + orientation.unitVector, moveValidator)
            MoveDirection.BACKWARD -> setPosition(pos - orientation.unitVector, moveValidator)
        }
    }

    private fun setPosition(newPosition: Vector2d, validator: MoveValidator) {
        if (validator.canMoveTo(newPosition))
            pos = newPosition
    }
}

fun main() {
    val animal = Animal()
    animal.orientation
}