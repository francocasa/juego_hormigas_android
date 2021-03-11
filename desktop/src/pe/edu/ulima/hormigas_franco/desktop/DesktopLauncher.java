package pe.edu.ulima.hormigas_franco.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pe.edu.ulima.hormigas_franco.Juego_Hormigas_franco;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();


		config.width = Juego_Hormigas_franco.GAME_WIDTH;
		config.height = Juego_Hormigas_franco.GAME_HEIGHT;


		new LwjglApplication(new Juego_Hormigas_franco(), config);
	}
}
