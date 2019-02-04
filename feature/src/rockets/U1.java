package src.rockets;
import src.interfaces.*;

public class U1 extends Rocket{
	protected double chanceOfLaunchExplosion,chanceOfLandingCrash;
	
	public U1() {
		//rocket Cost $100 Million
		//rocket Weight 10 Tonnes
		//max Weight 18 Tonnes
		//percent For Lunch Explosion is 0.05 
		//percent For Landing Crash 0.01
		super(100,10,18,0.05,0.01);
	}
	
	public  boolean  launch(double cargoCarried) {
		chanceOfLaunchExplosion = percentForLunchExplosion * (cargoCarried/percentForLunchExplosion);
		return true;
	}
	public  boolean  land(double cargoCarried) {
		chanceOfLandingCrash = chanceOfLandingCrash * (cargoCarried/percentForLandingCrash);
		return true;
	}
}
