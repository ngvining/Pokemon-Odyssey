package com.game.pokemon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.game.pokemon.Screens.GameScreen;
import com.game.pokemon.Screens.MainMenu;


public class Pokemon extends Game {

	//Static variables for the Desktop Application Class
	public static String GAMENAME = "Pokemon Odyssey";
	public static double VERSION = 0.1;
	public static int gamewindowwidth = 600;
	public static int gamewindowheight = 600;
	public static int windowpositionx = -1;
	public static int windowpositiony = -1;
	public static boolean vsync = true;

	@Override
	public void create () {

		this.setScreen(new GameScreen(this));

	}

	@Override
	public void render () {

		super.render();

	}

	@Override
	public void dispose () {

	}
}
