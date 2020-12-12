package INFO6205;

/**
 * This class is used to move people and track their positions
 */
public class Movement {
	public Movement(People people, double t) {
		stay=true;
		this.people = people;
		finish = t;
		TimeStaying =0;
	}
	public boolean makeStay() {
		if(++TimeStaying >=finish) return true;
		else return false;
	}
	public Movement(People people, Position newPosition) {
		this.people = people;
		this.newPosition = newPosition;
		move = direction();
		people.State=true;
		Position oldPosition = CanvasHelper.matrix[people.x][people.y];
		oldPosition.people.remove(people);
		if(oldPosition.place !=null) oldPosition.place.people.remove(people);
		people.thisPosition =null;
	}
	public int[] direction() {
		return new int[] {(int)Math.signum(newPosition.x- people.x),(int)Math.signum(newPosition.y- people.y)};
	}
	public boolean walk() {
		if(people.x != newPosition.x) {
			people.x+=move[0];
		}
		if(people.y != newPosition.y) {
			people.y+=move[1];
		}
		if(people.x== newPosition.x && people.y == newPosition.y) {
			people.State=false;
			Position newPosition = CanvasHelper.matrix[people.x][people.y];
			newPosition.people.add(people);
			if(newPosition.place !=null) newPosition.place.people.add(people);
			people.thisPosition = newPosition;
			return true;
		}
		else return false;
	}

	public boolean stay=false;
	public Position newPosition;
	private int move[];
	public People people;
	private int TimeStaying;
	private double finish;
}
