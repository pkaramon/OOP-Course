import java.util.*

fun main() {
    val map = BouncyMap(2, 2)
    map.place(Animal( Vector2d(0, 0)))
    map.place(Animal( Vector2d(1, 1)))

    println(map.objectAt(Vector2d(0, 0)))
    println(map.objectAt(Vector2d(1, 1)))


    map.place(Animal(Vector2d(0, 0)))
    map.place(Animal(Vector2d(1, 1)))

    println(map.getElements())

    map.place(Animal(Vector2d(0, 0)))



}

class BouncyMap(height: Int, width:Int): WorldMap {
    private val animals: MutableMap<Vector2d, Animal> = mutableMapOf()
    private val bounds: Boundary = Boundary(Vector2d(0, 0), Vector2d(height, width))

    override fun place(animal: Animal) {
        val mapEntry = animals.entries.find { it.value == animal }
        if (mapEntry != null) {
            animals.remove(mapEntry.value.position)
            animals[mapEntry.value.position] = mapEntry.value
        } else {
            bouncyPlace(animal)
        }
    }

    private fun bouncyPlace(animal: Animal) {
        val newPosition = findNewPosition(animal.position)
        newPosition?.let {
            animals[newPosition] = animal
            animal.position = newPosition
        }
    }

    private fun findNewPosition(oldPosition: Vector2d): Vector2d? {
        if (canMoveTo(oldPosition) && objectAt(oldPosition) == null) {
            return oldPosition
        }

        val freePosition = animals.randomFreePosition(bounds.upperRight)
        if (freePosition != null) {
            return freePosition
        }

        return animals.randomPosition()
    }


    override fun move(animal: Animal, direction: MoveDirection) {
        val oldPosition = animal.position
        animal.move(direction, this)
        val newPosition = animal.position
        if (oldPosition != newPosition) {
            animals.remove(oldPosition)
            animals[newPosition] = animal
        }
    }

    override fun isOccupied(position: Vector2d): Boolean {
        return animals.containsKey(position)
    }

    override fun objectAt(position: Vector2d): WorldElement? {
        return animals[position]
    }

    override fun getElements(): Collection<WorldElement> {
        return animals.values
    }

    override fun getId(): UUID {
        return UUID.randomUUID()
    }

    override fun getCurrentBounds(): Boundary {
        return bounds
    }


    override fun canMoveTo(position: Vector2d): Boolean {
        return bounds.lowerLeft <= position && position <= bounds.upperRight
    }
}

