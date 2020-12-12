package INFO6205;

import INFO6205.Place.Place;
import INFO6205.Place.Place1;
import INFO6205.Place.Place2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/* this is class will be used to populate people and places */

public class CanvasHelper {

	public static void updateConsole() {
		PrintConsole.print();
	}

	public CanvasHelper() {
		if(canvasHelper ==null) canvasHelper = this;
		CanvasHelper.canvasSize = 350;
		people = new HashSet<>();
		place = new ArrayList<>();
		place1 = new ArrayList<>();
		refreshCanvas();
	}

	public void populatePeople(int count) {
		Random r = new Random();
		r.setSeed(500);
		for(int i=0;i<count;i++) {
			Place place1 = place.get(r.nextInt(place.size()));
			Place place2 = nearPlace(CanvasHelper.place1,place1);
			People people = new People(place1,place2);
			CanvasHelper.people.add(people);
			((Place1)place1).people1.add(people);
		}
	}

	public void refreshCanvas()
	{
		matrix = new Position[canvasSize][canvasSize];
		for(int i = 0; i< canvasSize; i++) {
			for(int j = 0; j< canvasSize; j++) {
				matrix[i][j] = new Position(i,j);
			}
		}

	}


	public void initaiatingDisease() {
		int c = 0;
		for(People v : people) {
			if(c>= people.size() || c==2) break;
			v.isSars = true;
			c++;
		}
		CanvasHelper.numberOfActiveCases = 2;
		CanvasHelper.numberOfInfected = 2;
	}
	
	public static Place nearPlace(List<Place> placesList, Place place1){
		Random r = new Random();
		if (SimProperties.flag123) r.setSeed(500);
		Place place = placesList.get(0);
		int min1 = Integer.MAX_VALUE;
		for(Place p : placesList) {
			int sum = r.nextInt(220) + Position.getDistancePlace(p,place1);
			if(sum<min1) {
				min1 = sum;
				place = p;
			}
		}
		return place;
	}
	public void spreadCanavas(boolean isplace, int num, int placeSize, int varSize) {
		int t = 0;
		Random r = new Random();
		int set = 0;
		while(set<num && t<=num*5) {
			t++;
			int X = r.nextInt(canvasSize);
			int Y = r.nextInt(canvasSize);
			if (matrix[X][Y].place != null) continue;
			List<Position> positions = new ArrayList<>();
			if (isplace==true) {
				Place p = new Place1(positions);
				populatingCanvas(p, positions, placeSize, varSize, X, Y, true);
				if (positions.size() > 0) {
					CanvasHelper.place.add(p);
					set++;
				}
			}
			else if (isplace==false) {
					Place p1 = new Place2(positions);
					populatingCanvas(p1, positions, placeSize, varSize, X, Y, false);
					if (positions.size() > 0) {
						place1.add(p1);
						set++;

					}
				} }
		}

	public void refreshCanvasHelper() {
		for(People people: people) {
			if(!people.hasResistance) people.refresh();
		}
	}

	public double populatingCanvas(Place place, List<Position> positions, int placeSize, int varSize, int r, int c, boolean isPlace) {
		Random r2 = new Random();
		if (SimProperties.flag123) r2.setSeed(500);
		//(varSize*2)
		double h = r2.nextDouble()+(placeSize-varSize);
		//*(varSize*2)
		double wid = r2.nextDouble()+(placeSize-varSize);
		for(int i=0;i<h;i++) {
			if((i+r)>= canvasSize -2) break;
			for (int j=0;j<wid;j++) {
				if((j+c)>= canvasSize -2) break;
				Position tempPosition = matrix[r+i][c+j];
				if(tempPosition.place !=null) continue;
				tempPosition.isplace1 =isPlace;
				positions.add(tempPosition);
				tempPosition.place = place;
			}
		}
		return wid*h;
	}

	public void lockdownPlace(List<Place> places) {
		for(Place p : places) {
			p.checkLockdown =true;
		}
	}
	
	public void removeLockdown(List<Place> places) {
		for(Place p : places) {
			p.checkLockdown =false;
		}
	}
	
	public void spreadInfection(List<Place> places) {
		for (Place p : places) {
			List<People> peopleinPlace2 = new ArrayList<>(p.people);
			for(int s =0;s <peopleinPlace2.size();s ++) {
				if (!peopleinPlace2.get(s ).isSars || peopleinPlace2.get(s ).State==true) continue;
				for(int v =0;v <peopleinPlace2.size();v ++) {
					if(s ==v  || peopleinPlace2.get(v ).isSars || peopleinPlace2.get(v ).State==true) continue;
					peopleinPlace2.get(v ).spreadDisease(peopleinPlace2.get(s ));
				}
			}
		}
	}
	static List<Place> place;
	static List<Place> place1;
	static public CanvasHelper canvasHelper;
	static Position[][] matrix;
	static Set<People> people;
	static int canvasSize;
	static int numberOfFatality = 0;
	//static int numberOfTest = 0;
	static int numberOfPTest = 0;
	static int numberOfInfected = 0;
	static int numberOfActiveCases = 0;
	static int ImmuneCases = 0;
	//static int numberOfQua = 0;
}
