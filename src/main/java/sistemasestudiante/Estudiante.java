
package sistemasestudiante;

public class Estudiante {
    private int matricula;
    private String nombre;
    private int edad;
    private float promedio;

    public Estudiante(int matricula, String nombre, int edad, float promedio) {
        setMatricula(matricula);
        setNombre(nombre);
        setEdad(edad);
        setPromedio(promedio);
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        if(0 <= promedio && promedio <= 10){
            this.promedio = promedio;
        }else{
            throw new IllegalArgumentException("El promedio es invalido");
        }
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        if(matricula > 0){
            this.matricula = matricula;
        }else{
            throw new IllegalArgumentException("Matricula invalida");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Nombre invalido");
        }
            this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad > 0){
            this.edad = edad;
        }else{
            throw new IllegalArgumentException("La edad es invalida");
        }
    }

    @Override
    public String toString() {
        return "\nEstudiante: " +nombre+ "\nMatricula: " + matricula + "\nEdad: " + edad + "\nPromedio: " + promedio;
    }
}