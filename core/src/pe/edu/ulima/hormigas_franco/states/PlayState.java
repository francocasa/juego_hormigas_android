package pe.edu.ulima.hormigas_franco.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;



import java.util.Map;

import pe.edu.ulima.hormigas_franco.GameStateManager;
import pe.edu.ulima.hormigas_franco.Juego_Hormigas_franco;
import pe.edu.ulima.hormigas_franco.Unidades.Alacran;
import pe.edu.ulima.hormigas_franco.Unidades.Hormiga_Grande;
import pe.edu.ulima.hormigas_franco.Unidades.Hormiga_chica;
import pe.edu.ulima.hormigas_franco.Unidades.Muerte_Alacranes;
import pe.edu.ulima.hormigas_franco.Unidades.Muerte_Hormiga_Grande;
import pe.edu.ulima.hormigas_franco.Unidades.Muerte_Hormiga_chica;

/**
 * Created by sodm on 7/11/2017.
 */

public class PlayState extends GameState implements Input.TextInputListener
{
    String jugador = "";
    boolean terminado = false;
    boolean nuevoJuego = false;

    private Texture mTexBackground;
    private Hormiga_chica mHormigaChica;
    private Hormiga_Grande mHormigaGrande;
    private Alacran mAlacran;
    private int puntaje = 0;
    private int contador1 = 0;
    private int contador2 = 0;
    private int contador3 = 0;


    private Array<Hormiga_chica> mArrayHormigasChicas;
    private Array<Muerte_Hormiga_chica> mArrayMuerteHormigasChicas;

    private Array<Hormiga_Grande> mArrayHormigasGrandes;
    private Array<Muerte_Hormiga_Grande> mArrayMuerteHormigasGrandes;

    private Array<Alacran> mArrayAlacranes;
    private Array<Muerte_Alacranes> mArrayMuertesAlacranes;


    Map<Integer, Hormiga_chica> hormigasChicas;


    Vector3 touchPos;


    private Music music;
    private Sound splash;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        mTexBackground = new Texture("bg_game1.jpg");

        // donde se encuentra la hormiga al inicio

        mArrayHormigasChicas = new Array<Hormiga_chica>();
        mArrayMuerteHormigasChicas = new Array<Muerte_Hormiga_chica>();

        mArrayHormigasGrandes = new Array<Hormiga_Grande>();
        mArrayMuerteHormigasGrandes = new Array<Muerte_Hormiga_Grande>();

        mArrayAlacranes = new Array<Alacran>();
        mArrayMuertesAlacranes = new Array<Muerte_Alacranes>();

            mArrayHormigasChicas.add(new Hormiga_chica(0,1280));

        music = Gdx.audio.newMusic(Gdx.files.internal("musica.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();

        splash = Gdx.audio.newSound(Gdx.files.internal("splash.mp3"));

        /*
        mHormigaGrande = new Hormiga_Grande(0,1280);
        mHormigaChica = new Hormiga_chica(0,1280);
        mAlacran = new Alacran(0,1280);
*/
        touchPos = new Vector3();
    }


    @Override
    public void handleInput() {


        if (Gdx.input.justTouched()){

            touchPos.set(Gdx.input.getX(),Gdx.input.getY(),0);
            mCam.unproject(touchPos);

            for (int i=0;i<mArrayHormigasChicas.size;i++)
            {

                Hormiga_chica unidad = mArrayHormigasChicas.get(i);
                if(touchPos.x > unidad.getPosicion().x &&
                        touchPos.x < unidad.getPosicion().x + unidad.getTexture().getRegionWidth())
                {

                    if(touchPos.y > unidad.getPosicion().y&&
                            touchPos.y < unidad.getPosicion().y + unidad.getTexture().getRegionHeight())
                    {
                        puntaje = puntaje + 10;

                        splash.play();

                        mArrayMuerteHormigasChicas.add(new Muerte_Hormiga_chica(
                                (int)unidad.getPosicion().x ,(int)unidad.getPosicion().y));
                        mArrayHormigasChicas.removeIndex(i);
                    }
                }
            }


            for (int i=0;i<mArrayHormigasGrandes.size;i++)
            {

                Hormiga_Grande unidad = mArrayHormigasGrandes.get(i);
                if(touchPos.x > unidad.getPosicion().x &&
                        touchPos.x < unidad.getPosicion().x + unidad.getTexture().getRegionWidth())
                {

                    if(touchPos.y > unidad.getPosicion().y&&
                            touchPos.y < unidad.getPosicion().y + unidad.getTexture().getRegionHeight())
                    {
                        puntaje = puntaje + 20;

                        splash.play();

                        mArrayMuerteHormigasGrandes.add(new Muerte_Hormiga_Grande(
                                (int)unidad.getPosicion().x ,(int)unidad.getPosicion().y));
                        mArrayHormigasGrandes.removeIndex(i);
                    }
                }
            }


            for (int i=0;i<mArrayAlacranes.size;i++)
            {

                Alacran unidad = mArrayAlacranes.get(i);
                if(touchPos.x > unidad.getPosicion().x &&
                        touchPos.x < unidad.getPosicion().x + unidad.getTexture().getRegionWidth())
                {

                    if(touchPos.y > unidad.getPosicion().y&&
                            touchPos.y < unidad.getPosicion().y + unidad.getTexture().getRegionHeight())
                    {
                        puntaje = puntaje + 30;

                        splash.play();

                        mArrayMuertesAlacranes.add(new Muerte_Alacranes(
                                (int)unidad.getPosicion().x ,(int)unidad.getPosicion().y));
                        mArrayAlacranes.removeIndex(i);
                    }
                }
            }


        }


        for(int i=0; i<mArrayHormigasChicas.size;i++)
        {

            Hormiga_chica unidad = mArrayHormigasChicas.get(i);
            if(unidad.getPosicion().y + unidad.getTexture().getRegionHeight() <= 0) {
                terminado = true;
                Gdx.input.getTextInput(this, "JUEGO TERMINADO \n PUNTAJE: " + puntaje, "", "pon tu nombre");

            }

        }

        for(int i=0; i<mArrayHormigasGrandes.size;i++)
        {

            Hormiga_Grande unidad = mArrayHormigasGrandes.get(i);
            if(unidad.getPosicion().y + unidad.getTexture().getRegionHeight() <= 0) {
                terminado = true;
                Gdx.input.getTextInput(this, "JUEGO TERMINADO \n PUNTAJE: " + puntaje, "", "pon tu nombre");

            }

        }

        for(int i=0; i<mArrayAlacranes.size;i++)
        {

            Alacran unidad = mArrayAlacranes.get(i);
            if(unidad.getPosicion().y + unidad.getTexture().getRegionHeight() <= 0) {
                terminado = true;
                Gdx.input.getTextInput(this, "JUEGO TERMINADO \n PUNTAJE: " + puntaje, "", "pon tu nombre");

            }

        }


    }


    @Override
    public void update(float dt) {

        if(terminado == true)
        {
            if(nuevoJuego)
            {
                mGSM.set(new MenuState(mGSM));
            }
        }
        else {


            contador1++;
            contador2++;
            contador3++;


            for (int i = 0; i < mArrayHormigasChicas.size; i++) {
                Hormiga_chica unidad = mArrayHormigasChicas.get(i);
                unidad.update(dt);
            }

            for (int i = 0; i < mArrayHormigasGrandes.size; i++) {
                Hormiga_Grande unidad = mArrayHormigasGrandes.get(i);
                unidad.update(dt);
            }

            for (int i = 0; i < mArrayAlacranes.size; i++) {
                Alacran unidad = mArrayAlacranes.get(i);
                unidad.update(dt);
            }


            if (contador1 == 200) {
                mArrayHormigasChicas.add(new Hormiga_chica(0, 1280));
                contador1 = contador1 - 200;
            }
            if (contador2 == 400) {
                mArrayHormigasGrandes.add(new Hormiga_Grande(0, 1280));
                contador2 = contador2 - 300;
            }
            if (contador3 == 600) {
                mArrayAlacranes.add(new Alacran(0, 1280));
                contador3 = contador3 - 500;
            }

        /*
        mHormigaChica.update(dt);
        mHormigaGrande.update(dt);
        mAlacran.update(dt);
        */
            handleInput();
        }
    }


    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(mCam.combined);
        sb.begin();

        sb.draw(mTexBackground, 0, 0, mCam.viewportWidth, mCam.viewportHeight);


        for(int i=0; i<mArrayMuerteHormigasChicas.size;i++)
        {
            Muerte_Hormiga_chica unidad = mArrayMuerteHormigasChicas.get(i);
            sb.draw(unidad.getTexture(),
                    unidad.getPosicion().x,
                    unidad.getPosicion().y);
        }

        for(int i=0; i<mArrayMuerteHormigasGrandes.size;i++)
        {
            Muerte_Hormiga_Grande unidad = mArrayMuerteHormigasGrandes.get(i);
            sb.draw(unidad.getTexture(),
                    unidad.getPosicion().x,
                    unidad.getPosicion().y);
        }

        for(int i = 0; i< mArrayMuertesAlacranes.size; i++)
        {
            Muerte_Alacranes unidad= mArrayMuertesAlacranes.get(i);
            sb.draw(unidad.getTexture(),
                    unidad.getPosicion().x,
                    unidad.getPosicion().y);
        }



        for(int i=0; i<mArrayHormigasChicas.size;i++)
        {

            Hormiga_chica unidad = mArrayHormigasChicas.get(i);
            sb.draw(unidad.getTexture(),
                    unidad.getPosicion().x,
                    unidad.getPosicion().y);

        }

        for(int i=0; i<mArrayHormigasGrandes.size;i++)
        {

            Hormiga_Grande unidad = mArrayHormigasGrandes.get(i);
            sb.draw(unidad.getTexture(),
                    unidad.getPosicion().x,
                    unidad.getPosicion().y);

        }

        for(int i=0; i<mArrayAlacranes.size;i++)
        {

            Alacran unidad = mArrayAlacranes.get(i);
            sb.draw(unidad.getTexture(),
                    unidad.getPosicion().x,
                    unidad.getPosicion().y);

        }


        /*
            // aca se mostrara la hormiga
        sb.draw(mHormigaChica.getTexture(),
                mHormigaChica.getPosicion().x,
                mHormigaChica.getPosicion().y);


        sb.draw(mHormigaGrande.getTexture(),
                mHormigaGrande.getPosicion().x,
                mHormigaGrande.getPosicion().y);

        sb.draw(mAlacran.getTexture(),
                mAlacran.getPosicion().x,
                mAlacran.getPosicion().y);
*/

        sb.end();

    }


    @Override
        public void dispose() {

        mTexBackground.dispose();
        /*
        mHormigaChica.dispose();
        mHormigaGrande.dispose();
        mAlacran.dispose();
        */
        for(int i=0; i<mArrayHormigasChicas.size;i++)
        {
            mArrayHormigasChicas.get(i).dispose();
        }
        for(int i=0; i<mArrayHormigasGrandes.size;i++)
        {
            mArrayHormigasGrandes.get(i).dispose();
        }
        for(int i=0; i<mArrayAlacranes.size;i++)
        {
            mArrayAlacranes.get(i).dispose();
        }
        for(int i=0; i<mArrayMuerteHormigasChicas.size;i++)
        {
            mArrayMuerteHormigasChicas.get(i).dispose();
        }
        for(int i=0; i<mArrayMuerteHormigasGrandes.size;i++)
        {
            mArrayMuerteHormigasGrandes.get(i).dispose();
        }
        for(int i=0; i<mArrayMuertesAlacranes.size;i++)
        {
            mArrayMuertesAlacranes.get(i).dispose();
        }

        music.dispose();
    }

    @Override
    public void input(String text) {

        jugador = text;

        Juego_Hormigas_franco.envioPuntuacion.submitScore(jugador, puntaje);

        nuevoJuego = true;
        System.out.println(jugador);

    }

    @Override
    public void canceled() {
        jugador = "vacio";
        nuevoJuego = true;
        System.out.println(jugador);

    }



}
