package INFO6205;


import INFO6205.Place.Place;
import java.util.HashSet;
import java.util.Set;

public class Position {

	public static int getDistancePlace(Place p1, Place p2) {
		int x1 = p1.positions.get(0).x,y1 = p1.positions.get(0).y,x2 = p2.positions.get(0).x,y2 = p2.positions.get(0).y;
		return (int)Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}

	public static int getEucladianDistance(int x1,int x2,int y1,int y2) {
		return (int)Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		people = new HashSet<>();
	}

	public int x;
	public int y;
	public Place place;
	public boolean isplace1;
	public Set<People> people;

}
