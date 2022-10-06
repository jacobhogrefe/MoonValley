package Screens;

import Engine.GraphicsHandler;
import Engine.Screen;
import Maps.HouseMap;
import Players.Cat;

public class HouseScreen extends Screen {
    protected HouseMap map;
	protected Cat player;

	public void initialize() {
       //set up map
		this.map = new HouseMap();
		
		//set up player
		this.player = new Cat(map.getPlayerStartPosition().x, map.getPlayerStartPosition().y);
    }   

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		map.draw(player, graphicsHandler);	
	}      
}