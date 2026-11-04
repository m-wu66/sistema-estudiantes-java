
package sistemasestudiante;

import java.util.ArrayList;

public class EstudianteServicio {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    
    public boolean agregarEstudiante(Estudiante estudiante){
        if(buscarEstudiante(estudiante.getMatricula()) != null){
           return false;
        }
        estudiantes.add(estudiante); 
    return true;
    }
    
    public void mostrarEstudiantes(){
        if(estudiantes.isEmpty()){
            System.out.println("No hay estudiantes registrados");
        }
        for(Estudiante est: estudiantes){
            System.out.println(est);
            System.out.println("");
        }
    }
    
    public Estudiante buscarEstudiante(int matricula){
        for(Estudiante estudiante: estudiantes){
            if(estudiante.getMatricula() == matricula){
                return estudiante;
            }
        }
        return null;
    }
    
    public boolean eliminarEstudiante(int matricula){
        Estudiante estudiante = buscarEstudiante(matricula);
        if(estudiante != null){
            estudiantes.remove(estudiante);
            return true;
        }
    return false;
    }
    
    public boolean actualizarEstudiante(int matricula, String nuevoNombre, int nuevaEdad, float nuevoPromedio){
        Estudiante estudiante = buscarEstudiante(matricula);
            if(estudiante == null){
                return false;
            }
        try{
            Estudiante estudianteTemporal = new Estudiante(matricula, nuevoNombre, nuevaEdad, nuevoPromedio);
            estudiante.setNombre(estudianteTemporal.getNombre());
            estudiante.setEdad(estudianteTemporal.getEdad());
            estudiante.setPromedio(estudianteTemporal.getPromedio());
            return true;
        }catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
    return false;
    }
}