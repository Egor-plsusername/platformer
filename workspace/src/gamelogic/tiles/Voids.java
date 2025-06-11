package gamelogic.tiles;

import gameengine.hitbox.RectHitbox;
import gameengine.loaders.Tileset;
import gamelogic.GameResources;
import gamelogic.level.Level;

import java.awt.Color;
import java.awt.Graphics;

public class Voids extends Tile{

	public static final int HORIZONTAL_DOWNWARDS = 0;
	public static final int HORIZONTAL_UPWARDS = 1;
	public static final int VERTICAL_LEFTWARDS = 2;
	public static final int VERTICAL_RIGHTWARDS = 3;
	
	private float x;
	private float y;
	private int offsetX = 25;
	private int offsetY = 70;
	private int orientation;
	private RectHitbox pass;


	public Voids(float x, float y, int size, int orientation, Level level) {
		super(x, y, size, null, true, level);
		offsetX = (int)(level.getLevelData().getTileSize()*0.1);
		offsetY = (int)(level.getLevelData().getTileSize()/2);
		this.x = x;
		this.y= y;
		this.orientation=orientation;
	
		turnOnHitbox();
	
		switch (orientation) {
		case HORIZONTAL_UPWARDS:
			pass = new RectHitbox(x*size , y*size, offsetX, offsetY, size - offsetX , size);
			break;
		case HORIZONTAL_DOWNWARDS:
			pass = new RectHitbox(x*size , y*size, offsetX, 0, size , size-offsetY);
			break;
		case VERTICAL_LEFTWARDS:
			pass = new RectHitbox(x*size , y*size, offsetY, offsetX, size,  size - offsetX);
			break;
		case VERTICAL_RIGHTWARDS:
			pass = new RectHitbox(x*size , y*size,0, offsetX, size - offsetY, size - offsetX);
			break;

		default:
			break;
		}

	}

	public void draw(Graphics g){
		super.draw(g);
		pass.color = Color.RED;
		pass.draw(g);
	}

		public RectHitbox getOffBox() {
		return pass;
	}


	 public void turnOffHitbox(){
		hitbox = null;
}

	public void turnOnHitbox(){
			Tileset tileset = GameResources.tileset;
	switch (orientation) {
		case HORIZONTAL_UPWARDS:
			hitbox = new RectHitbox(x*size , y*size, offsetX, 5, size , size-offsetY);
			image = tileset.getImage("vrit");
			break;
		case HORIZONTAL_DOWNWARDS:
			hitbox = new RectHitbox(x*size , y*size, offsetX, offsetY, size - offsetX, size);
			image = tileset.getImage("wungus");
			break;
		case VERTICAL_LEFTWARDS:
			hitbox = new RectHitbox(x*size , y*size, 0, offsetX, size - offsetY, size - offsetX);
			image = tileset.getImage("plute");
			break;
		case VERTICAL_RIGHTWARDS:
			hitbox = new RectHitbox(x*size , y*size, offsetY, offsetX, size, size - offsetX);
			image = tileset.getImage("plimp");
			break;

		default:
			break;
		}
	}

	
}
