package pe.edu.ulima.hormigas_franco.animaciones;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by sodm on 7/13/2017.
 */

public class Animacion_Muerte_Hormiga_Chica {
    private Array<TextureRegion> mFrames;
    private float mMaxFrameTime;
    private float mCurrentFrameTime = 0;
    private int mFrameCount;
    private int mCurrentFrameIndex;


    public Animacion_Muerte_Hormiga_Chica(Texture region, int frameCount, float cycleTime){
        mFrames = new Array<TextureRegion>();
        int frameWidth = region.getWidth() / frameCount;
        for (int i=0; i<1; i++){
            mFrames.add(new TextureRegion(region,
                    i * frameWidth, region.getHeight()*2/3,
                    frameWidth, region.getHeight()/3));

        }
        mFrameCount = 1;
        mMaxFrameTime = cycleTime / mFrameCount;
        mCurrentFrameIndex = 0;
    }


    public void update(float dt){
// Primero si cambio de frame
        mCurrentFrameTime += dt;
        if (mCurrentFrameTime > mMaxFrameTime){
// Tenemos que cambiar al otro frame
            mCurrentFrameIndex++;
// Reiniciamos el tiempo en el frame
            mCurrentFrameTime = 0;
        }
        if (mCurrentFrameIndex == mFrameCount){
            mCurrentFrameIndex = 0;
        }
    }


    public TextureRegion getFrame(){
        return mFrames.get(mCurrentFrameIndex);
    }

}
