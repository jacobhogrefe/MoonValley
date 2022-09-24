package Engine;

import GameObject.ImageEffect;
import Level.ItemList;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class GraphicsHandler {

	private Graphics2D g;

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

	// Takes a list of items the player currently has in their inventory and draws a
	// graphic representation
	// If no items are in inventory, it will still draw the inventory with empty
	// spaces, the border and empty spaces that will always be drawn are coded at
	// the beginning of this method. It is a little confusing figuring out all the
	// steps to add a new item to the inventory so
	// feel free to ask me how it works if you can't figure it out from my comments
	// - Matt Z

	public void drawInventory(ItemList list) {
		// Load in tiles from the InventoryTileset png. For the "getSubImage" operation
		// you are putting in the coordinate of the upper left hand corner of your image
		// on the
		// tileset image, followed by the size of the square (16 pixels by 16 pixels).
		// The image is then scaled to the same size map tiles are which made centering
		// the
		// inventory easier for me.

		// VEYR IMPORTANT: If you draw a new item into the png file with the intention
		// of adding it to the draw logic here, IMMEDIATELY PUSH THE NEW IMAGE TO GITHUB
		// BEFORE YOU
		// START CODING HERE!! We will all be adding to the inventory and we do not want
		// conflicts to emerge when we try to use the same space on the grid. It
		// wouldn't be
		// terribly hard to fix, but it would be annoying nonetheless and you would
		// end up on my bad side.
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
		Image emptySlot = ImageLoader.load("InventoryTileset.png").getSubimage(17, 17, 16, 16).getScaledInstance(48, 48,
				Image.SCALE_SMOOTH);

		// START Drawing the frame of the inventory, will always load in the same
		// regardless of what is in inventory
		
		
		
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 3.0F);
		g.setFont(newFont);
		g.setColor(java.awt.Color.black);
		
		
		g.drawString("Your Beautiful Possessions", 165, 110);
		
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

		// Items:
		// In the future, this will determine which squares it should draw based on what
		// the player inventory contains. For now, it just generates blank inventory
		// spaces using the nested for statement method that almost killed me in CSC110
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 11; i++) {
				g.drawImage(emptySlot, 128 + (i * 48), (168 + (j * 48)), null);
			}
		}

	}
}
