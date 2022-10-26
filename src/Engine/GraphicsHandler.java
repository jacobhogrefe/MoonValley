package Engine;

import GameObject.ImageEffect;
import InventoryModifier.InventoryGrid;
import InventoryModifier.OptionsBox;
import NPCs.Walrus;
import Registry.ItemRegistry;
import Utils.Stopwatch;

import java.awt.*;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

public class GraphicsHandler {

	private Graphics2D g;
	private InventoryGrid inventoryGrid = new InventoryGrid();

	public void setGraphics(Graphics2D g) {
		this.g = g;
	}

	public void drawImage(BufferedImage image, int x, int y) {
		g.drawImage(image, x, y, null);
	}

	public void drawImage(BufferedImage image, int x, int y, int width, int height) {
		g.drawImage(image, x, y, width, height, null);
	}

	public void drawImage(BufferedImage image, int x, int y, int width, int height, ImageEffect imageEffect) {
		switch (imageEffect) {
		case NONE:
			drawImage(image, x, y, width, height);
			break;
		case FLIP_HORIZONTAL:
			g.drawImage(image, x + width, y, -width, height, null);
			break;
		case FLIP_VERTICAL:
			g.drawImage(image, x, y + height, width, -height, null);
			break;
		case FLIP_H_AND_V:
			g.drawImage(image, x + width, y + height, -width, -height, null);
			break;
		}
	}

	public void drawRectangle(int x, int y, int width, int height, Color color) {
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}

	public void drawRectangle(int x, int y, int width, int height, Color color, int borderThickness) {
		g.setStroke(new BasicStroke(borderThickness));
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}

	public void drawFilledRectangle(int x, int y, int width, int height, Color color) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void drawFilledRectangleWithBorder(int x, int y, int width, int height, Color fillColor, Color borderColor,
			int borderThickness) {
		drawFilledRectangle(x, y, width, height, fillColor);
		drawRectangle(x, y, width, height, borderColor, borderThickness);
	}

	public void drawString(String text, int x, int y, Font font, Color color) {
		g.setFont(font);
		g.setColor(color);
		g.drawString(text, x, y);
	}

	// https://stackoverflow.com/a/35222059 and https://stackoverflow.com/a/31831120
	public void drawStringWithOutline(String text, int x, int y, Font font, Color textColor, Color outlineColor,
			float outlineThickness) {
		// remember original settings
		Color originalColor = g.getColor();
		Stroke originalStroke = g.getStroke();
		RenderingHints originalHints = g.getRenderingHints();
		g.setStroke(new BasicStroke(outlineThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		// create a glyph vector from your text
		GlyphVector glyphVector = font.createGlyphVector(g.getFontRenderContext(), text);

		// get the shape object
		Shape textShape = glyphVector.getOutline();
		AffineTransform at = new AffineTransform();
		at.setToTranslation(Math.round(x), Math.round(y));
		textShape = at.createTransformedShape(textShape);

		// activate anti aliasing for text rendering (if you want it to look nice)
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g.setColor(outlineColor);
		g.draw(textShape); // draw outline

		g.setColor(textColor);
		g.fill(textShape); // fill the shape

		// reset to original settings after painting
		g.setColor(originalColor);
		g.setStroke(originalStroke);
		g.setRenderingHints(originalHints);
	}

	public void drawInventory(int[] playerInventory) {

		Image inventoryUpLeft = ImageLoader.load("InventoryTileset.png").getSubimage(0, 0, 16, 16).getScaledInstance(48,
				48, Image.SCALE_SMOOTH);
		Image inventoryUpRight = ImageLoader.load("InventoryTileset.png").getSubimage(34, 0, 16, 16)
				.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		Image inventoryTop = ImageLoader.load("InventoryTileset.png").getSubimage(17, 0, 16, 16).getScaledInstance(48,
				48, Image.SCALE_SMOOTH);
		Image inventoryLeft = ImageLoader.load("InventoryTileset.png").getSubimage(0, 17, 16, 16).getScaledInstance(48,
				48, Image.SCALE_SMOOTH);
		Image inventoryBotLeft = ImageLoader.load("InventoryTileset.png").getSubimage(51, 17, 16, 16)
				.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		Image inventoryBot = ImageLoader.load("InventoryTileset.png").getSubimage(68, 17, 16, 16).getScaledInstance(48,
				48, Image.SCALE_SMOOTH);
		Image inventoryBotRight = ImageLoader.load("InventoryTileset.png").getSubimage(51, 0, 16, 16)
				.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		Image inventoryRight = ImageLoader.load("InventoryTileset.png").getSubimage(34, 17, 16, 16)
				.getScaledInstance(48, 48, Image.SCALE_SMOOTH);

		// START Drawing the frame of the inventory, will always load in the same
		// regardless of what is in inventory

		Font inventoryTitleFont = new Font("Font", Font.ITALIC, 40);
		drawString("Your Beautiful Possessions", 148, 100, inventoryTitleFont, Color.BLACK);

		g.drawImage(inventoryUpLeft, 80, 120, null);

		for (int i = 0; i < 11; i++) {
			g.drawImage(inventoryTop, 128 + (i * 48), 120, null);
		}

		g.drawImage(inventoryUpRight, 656, 120, null);

		for (int i = 0; i < 5; i++) {
			g.drawImage(inventoryLeft, 80, (168 + (i * 48)), null);
		}

		g.drawImage(inventoryBotLeft, 80, 408, null);

		for (int i = 0; i < 11; i++) {
			g.drawImage(inventoryBot, 128 + (i * 48), 408, null);
		}
		g.drawImage(inventoryBotRight, 656, 408, null);

		for (int i = 0; i < 5; i++) {
			g.drawImage(inventoryRight, 656, (168 + (i * 48)), null);
		}

		// END Inventory frame

		// This nested for statement is confusing to look at, but the idea is it will
		// draw the image associated with the number stored at each index in the player
		// inventory.
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 11; i++) {
				g.drawImage(ItemRegistry.singleton.items.get(playerInventory[j * 11 + i]).texture, 128 + (i * 48),
						(168 + (j * 48)), null);

			}
		}

		// highlightSlot(0);

	}
	
	//draws an orange square over the inventory slot that has been clicked
	public void highlightSlot(int slotNumber) {
		int x = (int) inventoryGrid.getSlotCorner(slotNumber).getX();
		int y = (int) inventoryGrid.getSlotCorner(slotNumber).getY();

		drawRectangle(x, y, 48, 48, Color.ORANGE, 3);
	}
	
	// draws item information to an optionsbox
	public void drawOptionsBox(OptionsBox optionsBox) {
		Font descriptionFont = new Font("descriptionFont", Font.PLAIN, 15);
		Font nameFont = new Font("descriptionFont", Font.BOLD, 25);
	

		drawFilledRectangleWithBorder(240, 410, optionsBox.getBoxWidth(), optionsBox.getBoxHeight(), Color.LIGHT_GRAY,
				Color.BLACK, 2);
		g.drawImage(optionsBox.getItemImage(), 250, 420, null);

		if (optionsBox.getItemDescription().length() > 45) {

			drawString(optionsBox.getHalf1(), 250, 500, descriptionFont, Color.BLACK);
			drawString(optionsBox.getHalf2(), 248, 520, descriptionFont, Color.BLACK);
		} else {
			drawString(optionsBox.getItemDescription(), 250, 500, descriptionFont, Color.BLACK);
		}

		drawString(optionsBox.getItemName(), 320, 450, nameFont, Color.BLACK);
	}
	
	
	//draws buttons to optionsbox, only called when items are selected, not empty slots
	public void drawOptionsBoxButtons(OptionsBox optionsBox) {
		
		Font buttonFont = new Font("descriptionFont", Font.BOLD, 18);
		
		//move button
		drawFilledRectangleWithBorder(250,530,60,25,Color.GRAY,Color.BLACK,2);
		
		drawString("MOVE", 253, 550, buttonFont, Color.BLACK);
		
		
		
		//remove button
		drawFilledRectangleWithBorder(325,530,88,25,Color.GRAY,Color.BLACK,2);
		drawString("REMOVE", 328, 550, buttonFont, Color.BLACK);
		
	
		
	}
	public void drawOptionsBoxButtonsWithPlace(OptionsBox optionsBox) {
		
		Font buttonFont = new Font("descriptionFont", Font.BOLD, 18);
		
		//move button
		drawFilledRectangleWithBorder(250,530,60,25,Color.GRAY,Color.BLACK,2);
		
		drawString("MOVE", 253, 550, buttonFont, Color.BLACK);	
		
		//remove button
		drawFilledRectangleWithBorder(325,530,88,25,Color.GRAY,Color.BLACK,2);
		drawString("REMOVE", 328, 550, buttonFont, Color.BLACK);
		
		//Place button
		drawFilledRectangleWithBorder(427,530,72,25,Color.GRAY,Color.BLACK,2);
		drawString("PLACE", 432, 550, buttonFont, Color.BLACK);
		
	}
	
	public void highlightMove() {
		
		drawRectangle(250, 530, 60, 25, Color.ORANGE, 3);
	}
	
	public void highlightRemoveButton() {
		
		
		drawRectangle(325, 530, 88, 25, Color.ORANGE, 3);
	
	}
	
	public void unhighlightRemoveButton() {
		
		
		drawFilledRectangleWithBorder(325,530,88,25,Color.GRAY,Color.BLACK,2);
	
	}
	
	public void censorWalrus(Walrus walrus) {
		drawFilledRectangleWithBorder((int)walrus.getX(),(int)walrus.getY(),88,25,Color.BLACK,Color.BLACK,2);
	}
	
	

}
