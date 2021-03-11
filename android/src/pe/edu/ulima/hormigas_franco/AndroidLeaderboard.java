package pe.edu.ulima.hormigas_franco;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by sodm on 7/14/2017.
 */

public class AndroidLeaderboard implements EnvioPuntuacion {

    @Override
    public void submitScore(String user, int score) {
        Log.i("TAGG",user);
        Log.i("TAGG",score + "");

        PuntajePersona persona = new PuntajePersona(user, score);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbref = database.getReference();
        dbref.child("Puntuaciones").push().setValue(persona);
    }
}
