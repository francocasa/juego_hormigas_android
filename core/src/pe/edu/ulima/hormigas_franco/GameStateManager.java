package pe.edu.ulima.hormigas_franco;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

import pe.edu.ulima.hormigas_franco.states.GameState;

/**
 * Created by sodm on 7/11/2017.
 */

public class GameStateManager
{

     private Stack<GameState> mStates;
     public GameStateManager(){
     mStates = new Stack<GameState>();
     }
     public void push(GameState state){
     mStates.push(state);
     }
     public void pop(){
     mStates.pop().dispose();
     }
     public void set(GameState state){
     pop();
     push(state);
    }

    public void update(float dt){
    mStates.peek().update(dt);
    }
    public void render(SpriteBatch sb){
    mStates.peek().render(sb);
    }



}
