package com.game.pokemon.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.pokemon.Pokemon;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Pokemon.GAMENAME + " Version " + Pokemon.VERSION;
		config.width = Pokemon.gamewindowwidth;
		config.height = Pokemon.gamewindowheight;
		config.x = Pokemon.windowpositionx;
		config.y = Pokemon.windowpositiony;
		config.vSyncEnabled = Pokemon.vsync;
		config.addIcon("res/Master Ball.png", Files.FileType.Local);

		new LwjglApplication(new Pokemon(), config);
	}
}
