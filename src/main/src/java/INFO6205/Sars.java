package INFO6205;


public class Sars {

	public double getK_factor() {
		return k_factor;
	}

	public double getR_factor() {
		return r_factor;
	}

	public String getVirusType() {
		return virusType;
	}

	public int getPeriodOfInfection() {
		return periodOfInfection;
	}

	public int getPerToDevSymp() {
		return PerToDevSymp;
	}

	public double getProbabilitySymp() {
		return ProbabilitySymp;
	}

	public double getFatality() {
		return fatality;
	}

	public double getVirusInfect() {
		return virusInfect;
	}

	public Sars(){
		k_factor= SimProperties.k_factor;
		r_factor= SimProperties.r_factor;
		virusType= SimProperties.typeOfVirus;
	    periodOfInfection= SimProperties.infection;
		PerToDevSymp= SimProperties.exposetime;
		ProbabilitySymp= SimProperties.probTogetSym;
		fatality = SimProperties.fatality;
		virusInfect = SimProperties.infect;
	}

	public double k_factor;
	public double r_factor;
	public String virusType;
	public int periodOfInfection;
	public int PerToDevSymp;
	public double ProbabilitySymp;
	public double fatality;
	public double virusInfect;
	
}