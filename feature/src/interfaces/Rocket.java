package src.interfaces;

public abstract class Rocket {
	protected int rocketCost; //rocket Cost e.g. $100 Million
	protected int rocketWeight; //rocket Weight
	protected int maxWeight; //max Weight
	protected double percentForLunchExplosion; //percent For Lunch Explosion
	protected double percentForLandingCrash; //percent For Landing Crash


	public Rocket(int rocketCost,int rocketWeight,int maxWeight, double percentForLunchExplosion,double percentForLandingCrash) {

		this.rocketCost = rocketCost;
		this.rocketWeight = rocketWeight;
		this.maxWeight = maxWeight;
		this.percentForLunchExplosion = percentForLunchExplosion;
		this.percentForLandingCrash = percentForLandingCrash;
		
	}
	
	public boolean  canCarry() {
		return true;
	}
	public void  carry() {
		
	}

}
