package pe.edu.ulima.hormigas_franco;

/**
 * Created by sodm on 7/14/2017.
 */

public class PuntajePersona {
    private String nombre;
    private int puntaje;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public PuntajePersona(String nombre, int puntaje) {

        this.nombre = nombre;
        this.puntaje = puntaje;
    }
}
