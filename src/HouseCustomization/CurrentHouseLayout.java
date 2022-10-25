package HouseCustomization;

import java.awt.Point;
import java.util.ArrayList;

/*Keeps track of what furniture is currently in the house and where it is. 
* Used to make sure new furniture gets loaded into an unused point  (it would override other
*  furniture if it loaded in where something already was)
*/
public class CurrentHouseLayout {

	public static CurrentHouseLayout currenthouselayout = new CurrentHouseLayout();
	public ArrayList<Point> takenPoints = new ArrayList<Point>();

	public CurrentHouseLayout() {

	}

	public ArrayList<Point> getTakenPoints() {
		return takenPoints;
	}

	public void setTakenPoints(ArrayList<Point> takenPoints) {
		this.takenPoints = takenPoints;
	}
	

}