package pe.edu.ulima.hormigas_franco.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import pe.edu.ulima.hormigas_franco.GameStateManager;
import pe.edu.ulima.hormigas_franco.states.GameState;

/**
 * Created by sodm on 7/11/2017.
 */

public class MenuState extends GameState
{

    private Texture mTexBackground;
    private Texture mTextTitle;
    private Texture mTexButton;
    Vector3 touchPos;



    // esto me pidio crear cuando hice el extend
    public MenuState(GameStateManager gsm) {
        super(gsm);
        mTexBackground = new Texture("bg_game5.jpg");
        mTextTitle = new Texture("title.png");
        mTexButton = new Texture("start1.png");
        touchPos = new Vector3();
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){

            touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            mCam.unproject(touchPos);

            if(touchPos.x > mCam.position.x - (mTexButton.getWidth() *2 / 5) &&
                    touchPos.x < mCam.position.x + (mTexButton.getWidth() *2 / 5))
            {

                if(touchPos.y > mCam.position.y - 190 &&
                        touchPos.y < mCam.position.y + mTexButton.getHeight() - 190)
                {
                    mGSM.set(new PlayState(mGSM));
                }
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(mCam.combined);
        sb.begin();
        sb.draw(mTexBackground, 0, 0, mCam.viewportWidth, mCam.viewportHeight);

        sb.draw(mTextTitle,
                mCam.position.x - (mTextTitle.getWidth() / 2),
                mCam.position.y + 100);

        sb.draw(mTexButton,
                        mCam.position.x - (mTexButton.getWidth() / 2),
                        mCam.position.y - 200);
        sb.end();

    }

    @Override
    public void dispose() {
        mTexButton.dispose();
        mTexBackground.dispose();
        mTextTitle.dispose();
    }
}
