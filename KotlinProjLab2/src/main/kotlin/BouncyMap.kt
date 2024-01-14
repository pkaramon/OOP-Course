import java.util.*
import java.util.Random;

class BouncyMap(height: Int, width:Int): WorldMap {
    private val animals: MutableMap<Vector2d, Animal> = mutableMapOf()
    private val bounds: Boundary = Boundary(Vector2d(0, 0), Vector2d(height, width))
    private val rand = Random()

    override fun place(animal: Animal) {
        animals.entries.find { it.value == animal }?.let {
            animals.remove(it.key)
            bouncyPlace(animal)
        }

    }

    private fun bouncyPlace(animal: Animal) {
        val position = animal.position
        if(canMoveTo(position)) {
            animals[position] = animal
        } else {
            val freePosition = findRandomFreePosition()
            if (freePosition != null) {
                animal.position = freePosition
                animals[freePosition] = animal
            } else {

            }
        }
    }

    private fun findRandomFreePosition(): Vector2d? {
        val freePositions = (0..<bounds.width()).flatMap { x ->
            (0..<bounds.width()).map { y -> Vector2d(x, y) }
        }.filterNot { it in animals.keys }


        if (freePositions.isNotEmpty()) {
            return freePositions[rand.nextInt(freePositions.size)]
        }
        return null
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