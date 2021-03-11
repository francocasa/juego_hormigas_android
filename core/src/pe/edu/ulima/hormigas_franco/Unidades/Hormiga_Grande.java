package pe.edu.ulima.hormigas_franco.Unidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

import pe.edu.ulima.hormigas_franco.animaciones.Animacion_Hormiga_Grande;

/**
 * Created by sodm on 7/11/2017.
 */

public class Hormiga_Grande {

    private Animacion_Hormiga_Grande mAnimation;
    int partes = 5;

    private Vector3 mVelocidad;
    private Vector3 velocidadX;

    // preguntar si esto esta bien
    Random r = new Random();
    private int valor;
    private int diagonal = 0;
    private int lugar = 0;


    private Vector3 mPosicion;
    private Texture mTex;

    public Hormiga_Grande(int x, int y) {
        mTex = new Texture("ants1.png");
        mAnimation = new Animacion_Hormiga_Grande(mTex, partes, 0.5f);

        Random r = new Random();
        lugar = r.nextInt(720 - mTex.getWidth()/(partes)) + mTex.getHeight()/partes;

        diagonal = r.nextInt(2);
        if(diagonal == 0)
        {
            diagonal = -1;
        }
        else
        {
            diagonal = 1;
        }


        mVelocidad = new Vector3();
        mPosicion = new Vector3(lugar, y , 0);


    }
    public void update(float dt){
        mAnimation.update(dt);

        // PREGUNTAR ESTO
        if(mPosicion.x <= 0 || mPosicion.x + mTex.getWidth()/(partes*2) >= 720)
        {

            diagonal = diagonal*-1;
        }

        mVelocidad.add(diagonal*100,-100,0);
        mVelocidad.scl(dt);
        mPosicion.add(mVelocidad.x , mVelocidad.y, 0);
        mVelocidad.scl(1/dt);
        mVelocidad.add(-diagonal*100,100,0);

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
