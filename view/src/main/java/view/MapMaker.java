package view;

import java.awt.Graphics;

import view.Element.Background;
import view.Element.Character;
import view.Element.Diamond;
import view.Element.Dirt;
import view.Element.Exit;
import view.Element.Monster;
import view.Element.Rock;
import view.Element.Sprite;
import view.Element.Unbreakable;

public class MapMaker implements IMapMaker {
	private ISprite[][] sprites = new Sprite[22][40];
	private SpriteType map[][];
	private int x = 0, y = 0, ligne = 0, colonne = 0, characterX = 0, characterY = 0;

	/**
	 * The constructor of MapMaker,
	 * 
	 * @param translate
	 *            the translation of the query
	 */

	public MapMaker(TranslateMap translate) {
		this.map = translate.getMap();
		this.characterX = translate.getCharacterX();
		this.characterY = translate.getCharacterY();
	}

	/**
	 * Create the 880 sprites who are in the map and give then their position.
	 * Then he put them in the tab sprites.
	 * 
	 * @param SET_SIZE
	 *            the size of a sprite
	 */

	public void spritesCreation(final int SET_SIZE) {
		ligne = 0;
		for (SpriteType sousSpitTp[] : map) {
			x = 0;
			colonne = 0;
			for (SpriteType SpitTp : sousSpitTp) {
				switch (SpitTp) {
				case UNBREAKABLE:
					sprites[ligne][colonne] = new Unbreakable(x, y);
					break;
				case DIRT:
					sprites[ligne][colonne] = new Dirt(x, y);
					break;
				case BACKGROUND:
					sprites[ligne][colonne] = new Background(x, y);
					break;
				case ROCK:
					sprites[ligne][colonne] = new Rock(x, y);
					break;
				case DIAMOND:
					sprites[ligne][colonne] = new Diamond(x, y);
					break;
				case CHARACTER:
					sprites[ligne][colonne] = new Character(x, y);
					break;
				case EXIT:
					sprites[ligne][colonne] = new Exit(x, y);
					break;
				case MONSTER:
					sprites[ligne][colonne] = new Monster(x, y);
					break;
				default:
					break;
				}
				x = x + SET_SIZE;
				colonne++;
			}
			y = y + SET_SIZE;
			ligne++;
		}
	}

	/**
	 * Show the 880 sprites and their position
	 * 
	 * @param g
	 * 
	 */

	public void drawMap(Graphics g) {
		for (ISprite[] sousSpit : this.getSprites()) {
			for (ISprite spit : sousSpit) {
				g.drawImage(spit.getImage(), spit.getX(), spit.getY(), null);
			}
		}
	}

	/**
	 * 
	 * @return a two-dimensional table of Sprite
	 */

	public ISprite[][] getSprites() {
		return sprites;
	}

	/**
	 * 
	 * @return a Sprite in the two-dimensional table
	 */

	public ISprite getCharacter(int colonne, int ligne) {
		return sprites[ligne][colonne];
	}

	public void setSprites(ISprite[][] sprites) {
		this.sprites = sprites;
	}

	public void setAllHasMovedToFalse(ISprite[][] sprites) {
		for (ISprite sousSpit[] : sprites) {
			for (ISprite spit : sousSpit) {
				spit.setHasMoved(false);
			}
		}
	}

//	public ISprite[][] setDirtAndBackgroundToDiamond(ISprite[][] sprites, final int SET_SIZE) {
//		ligne = 0;
//		for (ISprite sousSpit[] : sprites) {
//			x = 0;
//			colonne = 0;
//			for (ISprite spit : sousSpit) {
//				if (spit.getType() == SpriteType.BACKGROUND || spit.getType() == SpriteType.DIRT) {
//					sprites[ligne][colonne] = new Diamond(x, y);
//				}
//				x = x + SET_SIZE;
//			}
//			y = y + SET_SIZE;
//		}
//		return sprites;
//	}
}
