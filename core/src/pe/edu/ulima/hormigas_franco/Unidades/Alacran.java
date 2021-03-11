package pe.edu.ulima.hormigas_franco.Unidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

import pe.edu.ulima.hormigas_franco.animaciones.Animacion_Alacran;

/**
 * Created by sodm on 7/11/2017.
 */

public class Alacran {

    private Animacion_Alacran mAnimation;
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

    public Alacran(int x, int y) {
        mTex = new Texture("ants1.png");
        mAnimation = new Animacion_Alacran(mTex, partes, 0.5f);

        Random r = new Random();
        lugar = r.nextInt(720 - mTex.getWidth()/(partes)) + mTex.getHeight()/partes;

        diagonal = r.nextInt(3)-1;


        mVelocidad = new Vector3();
        mPosicion = new Vector3(lugar, y , 0);


    }

    public void update(float dt){

        mAnimation.update(dt);


        if(mPosicion.x <= 0 || mPosicion.x + mTex.getWidth()/(partes*2) >= 720)
        {
            diagonal = diagonal*-1;
        }

        mVelocidad.add(diagonal*200,-200,0);
        mVelocidad.scl(dt);
        mPosicion.add(mVelocidad.x , mVelocidad.y, 0);
        mVelocidad.scl(1/dt);
        mVelocidad.add(-diagonal*200,200,0);

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
