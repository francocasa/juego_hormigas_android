package pe.edu.ulima.hormigas_franco.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pe.edu.ulima.hormigas_franco.GameStateManager;
import pe.edu.ulima.hormigas_franco.Juego_Hormigas_franco;

/**
 * Created by sodm on 7/11/2017.
 */

public abstract class GameState {


         protected OrthographicCamera mCam;
         protected GameStateManager mGSM;
         public GameState(GameStateManager gsm) {
             mGSM = gsm;
             mCam = new OrthographicCamera();
             mCam.setToOrtho(false,
                     Juego_Hormigas_franco.GAME_WIDTH ,
                     Juego_Hormigas_franco.GAME_HEIGHT );
         }
         public abstract void handleInput();
         public abstract void update(float dt);
         public abstract void render(SpriteBatch sb);
         public abstract void dispose();




}
