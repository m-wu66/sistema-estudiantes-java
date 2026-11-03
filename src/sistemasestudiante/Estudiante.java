
package sistemasestudiante;

public class Estudiante {
    private int matricula;
    private String nombre;
    private int edad;
    private float promedio;

    public Estudiante(int matricula, String nombre, int edad, float promedio) {
        this.matricula = matricula;
        this.nombre = nombre;
        setEdad(edad);
        setPromedio(promedio);
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        if(0 <= promedio && promedio <= 10){
            this.promedio = promedio;
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad > 0){
            this.edad = edad;
        }
    }

    @Override
    public String toString() {
        return "Estudiante: " +nombre+ "\nMatricula: " + matricula + "\nEdad: " + edad + "\nPromedio: " + promedio;
    }
}