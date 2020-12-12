package INFO6205;

import INFO6205.Place.Place;
import INFO6205.Place.Place1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class People {

	public double probabilityToGoOut;
	public People(){

	}
	public People(Place place1, Place place2) {
		this.place1 = place1;
		this.place2 = place2;
		populate();

	}
	public void refresh() {
		isRefreshed = false;
		frequencyTillInfection++;
		if(isSars) isInfecting();
		if(hasSeperated) requireQua();
		else if(movements.isEmpty()) doMovement();
		if(!movements.isEmpty()&& movements.peek().stay==false)
		{if(!movements.isEmpty() && movements.peek().walk())
			movements.remove();
		else
			return;
		}
		else if(!movements.isEmpty() && movements.peek().makeStay())
		{	movements.remove();}
	}
	
	public void isInfecting() {
		frequencyTillInfected++;
		if (frequencyTillInfected > sars.periodOfInfection) {
			CanvasHelper.numberOfActiveCases--;
			if(!willPeopleDie()||(!hasSymp))  {
				isSars =false;
				isImmune=true;
				hasSymp = false;
				CanvasHelper.ImmuneCases++;
			}
		}
		else if(frequencyTillInfected == sars.virusInfect) {
			if(Math.random()< sars.ProbabilitySymp) {
				hasSymp = true;
				if(!isSarsPositive) needForTest();
			}
		}
	}
	
	public void requireQua() {
		frequencyTillSeperation++;
		if((thisPosition ==null || thisPosition.place != place1) && movements.isEmpty()) {
			movements.add(new Movement(this, place1.returnRandomPosition()));
		}
	}

	public void doMovement() {
		if(Math.random()< probabilityToGoOut) {
			movements.clear();
			Position publicPosition = selectPosition();
			if(!publicPosition.place.checkLockdown) {
				movements.add(new Movement(this, publicPosition));
				movements.add(new Movement(this, 200));
			}
		}
		else{
			movements.add(new Movement(this, place1.returnRandomPosition()));
			movements.add(new Movement(this, 350));
		}
	}

	public boolean populate()
	{
		sars = new Sars();
		age= returnAge();
		powerImmun =returnImunityStrength();
		if (Math.random()<0.6) thisPosition = place1.returnRandomPosition();
		else thisPosition = place2.returnRandomPosition();
		x = thisPosition.x;
		y = thisPosition.y;
		probabilityToGoOut =.4;
		return true;
	}
	
	public Position selectPosition() {
		Random random = new Random();
		Position randomPublicPosition;
		if(SimProperties.flag15 ==null || random.nextDouble()> 0.5) {
			Place randomPublicPlace = CanvasHelper.nearPlace(CanvasHelper.place1, thisPosition.place);
			randomPublicPosition = randomPublicPlace.returnRandomPosition();
		}
		else {
			randomPublicPosition = SimProperties.flag15.returnRandomPosition();
		}
		return randomPublicPosition;
	}

	public void infectPerson() {
		isSars =true;
		CanvasHelper.numberOfInfected++;
		CanvasHelper.numberOfActiveCases++;
	}
	public boolean isFrontLineWorker()
	{
		if(Math.random()<0.2)
			return true;
		else
			return false;
	}

	public boolean spreadDisease(People infector) {
		if (isImmune || isRefreshed) return false;
		double dist = Position.getEucladianDistance(this.thisPosition.x,infector.thisPosition.x,this.thisPosition.y,infector.thisPosition.y);
		if(dist> SimProperties.sprange) return false;
		isRefreshed = true;
		boolean t=isFrontLineWorker();
		double chance=0.0;
		chance += sars.virusInfect;
		chance -= powerImmun;
		if(t);
		chance+=0.1;
		if(SimProperties.mask)
			chance-=0.15;
		if(SimProperties.socialDistance && dist>(SimProperties.sprange /2))
			chance-=0.15;
			
		if(chance>1.4) {

			infectPerson();
			return true;
		}
		else return false;
	}

	public boolean willPeopleDie() {
		double probOfDying = 0.0;
		probOfDying += sars.fatality;
		probOfDying -= powerImmun;
		if(probOfDying>1) {
			peopleDied();
			return true;
		}
		else return false;
	}

	public void needForTest() {
		frequencyTillInfection = 0;
		if(isSars && Math.random()<0.8) {
			isSarsPositive = true;
			CanvasHelper.numberOfPTest++;
			if(SimProperties.lockdownOnT) place2.checkLockdown =true;
			if(SimProperties.contactTrace) {
				for(People p : place2.people) {
					if(p.frequencyTillInfection > 500) p.needForTest();
				}
				for(People p : place1.people) {
					if(p.frequencyTillInfection > 500) p.needForTest();
				}
			}
		}
	}
	
	public void peopleDied() {
		if(thisPosition !=null) {
			thisPosition.people.remove(this);
			if(thisPosition.place !=null)
				thisPosition.place.people.remove(this);
		}

		((Place1) place1).people1.remove(this);
		CanvasHelper.numberOfFatality++;
		}

	public int returnAge() {
		Random r = new Random();
		int age =r.nextInt(80-10) + 10;
		return age;
	}

	public double returnImunityStrength() {
		Random r = new Random();
		double t = r.nextDouble();
		if(this.age >60) {t-= 0.005*this.age; }
		if(this.age<12){t-= 0.03*(12-this.age);}
		return t;
	}


	public Boolean hasResistance =false;
	public Boolean hasSeperated =false;
	public int frequencyTillInfected =0;
	public int frequencyTillSeperation =0;
	public boolean State=false;
	public Sars sars;
	public Boolean isSars =false;
	public Boolean isSarsPositive =false;
	public Boolean isImmune=false;
	public Position thisPosition;
	public int x;
	public int y;
	public Boolean hasSymp =false;
	public Boolean isRefreshed = false;
	public Place place1;
	public Place place2;
	public int age=0;
	public double powerImmun =0.0;
	public int frequencyTillInfection = 500;
	public Queue<Movement> movements = new LinkedList<>();

}
