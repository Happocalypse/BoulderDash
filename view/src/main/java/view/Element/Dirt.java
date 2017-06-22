package view.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.IPermeability;

public class Dirt extends Sprite{
	
	public Dirt(int x, int y, IPermeability permeability){
		super();
		this.permeability = permeability;
		this.x = x;
		this.y = y;
		
		try {
			image = ImageIO.read(new File("image/02.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
