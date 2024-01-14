import java.util.UUID

interface WorldMap : MoveValidator {

    @Throws(PositionAlreadyOccupiedException::class)
    fun place(animal: Animal)

    fun move(animal: Animal, direction: MoveDirection)

    fun isOccupied(position: Vector2d): Boolean

    fun objectAt(position: Vector2d): WorldElement?

    fun getElements(): Collection<WorldElement>

    fun getId(): UUID

    fun getCurrentBounds(): Boundary
}
