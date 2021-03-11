package pe.edu.ulima.hormigas_franco.Unidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import pe.edu.ulima.hormigas_franco.animaciones.Animacion_Muerte_Alacran;

/**
 * Created by sodm on 7/12/2017.
 */

public class Muerte_Alacranes {
    private Vector3 mPosicion;
    private Texture mTex;

    int partes = 5;

    private Animacion_Muerte_Alacran mAnimation;

    public Muerte_Alacranes(int x, int y) {


        mPosicion = new Vector3(x, y , 0);
        // preguntar sobre la imagen que tiene las hormigas
        mTex = new Texture("ants1.png");
        mAnimation = new Animacion_Muerte_Alacran(mTex, partes, 0.5f);
    }


    public void update(float dt){



    }


    public Vector3 getPosicion() {
        return mPosicion;
    }
    public TextureRegion getTexture(){
        return mAnimation.getFrame();
    }
    public void dispose(){
        mTex.dispose();
    }
}
