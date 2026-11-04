package sistemasestudiante;

import java.util.Scanner;

public class SistemasEstudiante {
    static Scanner sc = new Scanner(System.in);
    static EstudianteServicio servicio = new EstudianteServicio();
    public static void main(String[] args) {
        
        
        int op;
        
        System.out.println("== SISTEMA DE ESTUDIANTES ==");
        
        do{
            System.out.println("\n1. Registrar estudiante"
                            + "\n2. Mostrar estudiantes"
                            + "\n3. buscar estudiante"
                            + "\n4. Actualizar estudiante"
                            + "\n5. Eliminar estudiante"
                            +"\n6. Salir");

            System.out.print("\nSelecciona una opcion: ");
            op = sc.nextInt();

            switch(op){
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    servicio.mostrarEstudiantes();
                    break;
                case 3:
                    encontrarEstudiante();
                    break;
                case 4:
                    actualizarEstudiante();
                    break;
                case 5:
                    eliminarEstudiante();
                    break;
                case 6:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            
        }while(op != 6);
    sc.close();
    }
    
    public static void registrarEstudiante(){
        
        System.out.print("\nIngresa la matricula: ");
        int matricula = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingresa el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingresar la edad: ");
        int edad = sc.nextInt();
        System.out.print("Ingresar el promedio: ");
        float promedio = sc.nextFloat();
        
        try{
            Estudiante estudiante = new Estudiante(matricula, nombre, edad, promedio);
            if(servicio.agregarEstudiante(estudiante)){
                System.out.println("Se registro correctamente");
                return;
            }System.out.println("La matricula ya existe");
            
        }catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    public static void encontrarEstudiante(){
        System.out.print("\nIngresa la matricula del estudiante: ");
        int m = sc.nextInt();
        Estudiante es = servicio.buscarEstudiante(m);
        if(es == null){
            System.out.println("La matricula que ingresaste no existe");
            return;
        }
        System.out.println(es);
    }
    
    public static void actualizarEstudiante(){
        System.out.print("\nIngresa la matricula del estudiante: ");
        int matricula = sc.nextInt();
        if(servicio.buscarEstudiante(matricula) == null){
            System.out.println("No existe registro de ese alumno");
            return;
        }
        sc.nextLine();
        System.out.print("Ingresa el nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingresa la nueva edad: ");
        int edad = sc.nextInt();
        System.out.print("Ingresa el nuevo promedio: ");
        float promedio = sc.nextFloat();
        
        boolean actualizado = servicio.actualizarEstudiante(matricula, nombre, edad, promedio);

        if (actualizado) {
            System.out.println("Alumno actualizado");
        } else {
            System.out.println("No se pudo actualizar el alumno");
        }
    }

    public static void eliminarEstudiante(){
        System.out.print("\nIngresa la matricula del alumno: ");
        int m = sc.nextInt();
        if(servicio.eliminarEstudiante(m)){
            System.out.println("Se ha eliminado el registro del estudiante");
            return;
        }
        System.out.println("No existe registro de ese alumno");
    }
}
