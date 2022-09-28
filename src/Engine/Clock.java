package Engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Clock {
	private Timer timer;
	private int timeOfDay;
	public Clock()
	{	
		timeOfDay = 1;
		timer = new Timer(1200000 / Config.FPS, new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				if(timeOfDay<24)
				{
					timeOfDay++;
				}
				else if(timeOfDay==24)
				{
					timeOfDay=1;
				}
			}
		});
		updateTimer();
		timer.setRepeats(true);
	}
//returns time of day
	public int getTimeOfDay()
	{
		return timeOfDay;
	}
	public void updateTimer()
	{
		if(!timer.isRunning())
		{
			timer.start();
		}
	}
// return true for day, false for night
	public boolean isItDay()
	{
		if(timeOfDay<12)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
