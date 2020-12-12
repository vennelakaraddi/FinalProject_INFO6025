package INFO6205.Place;

import INFO6205.Position;
import INFO6205.People;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is the class used to set Position for people
 */
public class Place1 extends Place {
	public Set<People> people1;
	
	public Place1(List<Position> positions) {
		super(positions);
		people1 = new HashSet<>();
	}
}
