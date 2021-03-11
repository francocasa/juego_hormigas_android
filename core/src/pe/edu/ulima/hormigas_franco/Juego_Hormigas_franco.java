package pe.edu.ulima.hormigas_franco;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pe.edu.ulima.hormigas_franco.states.MenuState;

public class Juego_Hormigas_franco extends ApplicationAdapter {
	public static final int GAME_WIDTH = 780;
	public static final int GAME_HEIGHT = 1280;
	public static EnvioPuntuacion envioPuntuacion;

	private SpriteBatch batch;
	private	GameStateManager mGSM;

	Texture img;


	public Juego_Hormigas_franco(EnvioPuntuacion envioPuntuacion) {
		this.envioPuntuacion = envioPuntuacion;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		mGSM = new GameStateManager();

		mGSM.push(new MenuState(mGSM));
        Gdx.gl.glClearColor(1,0,0,1);
		// img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		mGSM.update(Gdx.graphics.getDeltaTime());
		mGSM.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();



		// img.dispose();
	}
}
