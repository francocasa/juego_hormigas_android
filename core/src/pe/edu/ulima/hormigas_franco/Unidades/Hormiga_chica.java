package pe.edu.ulima.hormigas_franco.Unidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

import pe.edu.ulima.hormigas_franco.animaciones.Animacion_Hormiga_Chica;

/**
 * Created by sodm on 7/11/2017.
 */

public class Hormiga_chica
{
    private Vector3 mVelocidad;
    private int lugar=0;
    private Vector3 mPosicion;
    private Texture mTex;
    private Animacion_Hormiga_Chica mAnimation;

    int partes = 5;

    public Hormiga_chica(int x, int y) {

        mTex = new Texture("ants1.png");
        mAnimation = new Animacion_Hormiga_Chica(mTex, partes, 0.5f);

        Random r = new Random();
        lugar = r.nextInt(720 - mTex.getWidth()/(partes)) + mTex.getHeight()/partes;

        mPosicion = new Vector3(lugar, y , 0);
        mVelocidad = new Vector3();





        // preguntar sobre la imagen que tiene las hormigas
        //mTex = new Texture("bird.png");
    }


    public void update(float dt){

        mAnimation.update(dt);

        mVelocidad.add(0,-100,0);
        mVelocidad.scl(dt);
        mPosicion.add(mVelocidad.x , mVelocidad.y, 0);
        mVelocidad.scl(1/dt);
        mVelocidad.add(0,100,0);

    }


    public Vector3 getPosicion() {
        return mPosicion;
    }
    /*public Texture getTexture(){
        return mTex;
    }*/
    public TextureRegion getTexture(){
        return mAnimation.getFrame();
    }
    public void dispose(){
        mTex.dispose();
    }


}
