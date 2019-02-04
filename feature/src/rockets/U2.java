package src.rockets;
import src.interfaces.*;

public class U2 extends Rocket{
	protected double chanceOfLaunchExplosion,chanceOfLandingCrash;
	
	public U2() {
		//rocket Cost $120 Million
		//rocket Weight 18 Tonnes
		//max Weight 29 Tonnes
		//percent For Lunch Explosion is 0.04
		//percent For Landing Crash 0.08
		super(120,18,29,0.04,0.08);
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
