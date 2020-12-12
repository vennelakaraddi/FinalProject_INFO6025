package INFO6205.Place;

import INFO6205.Position;
import INFO6205.People;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/** This is the class provide position to multiple people
 *
 */
public abstract class Place {


	public Place(List<Position> positions) {
		this.positions = positions;
		people = new HashSet<>();
		checkLockdown = false;
	}

	public Position returnRandomPosition() {
		Random random = new Random();
		return positions.get(random.nextInt(positions.size()));
	}
	public List<Position> positions;
	public Set<People> people;
	public Boolean checkLockdown;
	
}
