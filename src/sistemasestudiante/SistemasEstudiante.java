package sistemasestudiante;

import java.util.Locale;
import java.util.Scanner;

public class SistemasEstudiante {
    static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
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
            if(sc.hasNextInt() == false){
                op = 0;
                sc.nextLine();
            }else{
                op = sc.nextInt();
            }
            
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
        
        while(true){
            System.out.print("Ingresa la matricula: ");
            if(sc.hasNextInt()){
                break;
            }
            sc.next();
            System.out.println("Error, vuelve a intentarlo");
        }
        int matricula = sc.nextInt();
        sc.nextLine();
        String nombre;
        while(true){
            System.out.print("Ingresa el nombre: ");
            nombre = sc.nextLine();
            if(nombre.trim().isEmpty()){
                System.out.println("Error, vuelve a intentarlo");
            }else{
                break;
            }
            
        }
        
        while(true){
            System.out.print("Ingresar la edad: ");
            if(sc.hasNextInt()){
                break;
            }
            sc.next();
            System.out.println("Error, vuelve a intentarlo");
        }
        int edad = sc.nextInt();
        
        while(true){
            System.out.print("Ingresar el promedio: ");
            if(sc.hasNextFloat()){
                break;
            }
            sc.next();
            System.out.println("Error, vuelve a intentarlo");
        }
        float promedio = sc.nextFloat();
        sc.nextLine();
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
        while(true){
            System.out.print("\nIngresa la matricula del estudiante: ");
            if(sc.hasNextInt()){
                break;
            }
            sc.next();
            System.out.println("Error, vuelve a intentarlo");
        }
        int m = sc.nextInt();
        Estudiante es = servicio.buscarEstudiante(m);
        if(es == null){
            System.out.println("La matricula que ingresaste no existe");
            return;
        }
        System.out.println(es);
    }
    
    public static void actualizarEstudiante(){
         while(true){
            System.out.print("\nIngresa la matricula del estudiante: ");
            if(sc.hasNextInt()){
                break;
            }
            sc.next();
            System.out.println("Error, vuelve a intentarlo");
        }
        int matricula = sc.nextInt();
        sc.nextLine();
        if(servicio.buscarEstudiante(matricula) == null){
            System.out.println("No existe registro de ese alumno");
            return;
        }
        
        String nombre;
        while(true){
            System.out.print("Ingresa el nuevo nombre: ");
            nombre = sc.nextLine();
            if(nombre.trim().isEmpty()){
                System.out.println("Error, vuelve a intentarlo");
            }else{
                break;
            }
        }
        
        while(true){
            System.out.print("Ingresa la nueva edad: ");
            if(sc.hasNextInt()){
                break;
            }
            sc.next();
            System.out.println("Error, vuelve a intentarlo");
        }
        int edad = sc.nextInt();
        
        while(true){
            System.out.print("Ingresa el nuevo promedio: ");
            if(sc.hasNextFloat()){
                break;
            }
            sc.next();
            System.out.println("Error, vuelve a intentarlo");
        }
        float promedio = sc.nextFloat();
        sc.nextLine();
        boolean actualizado = servicio.actualizarEstudiante(matricula, nombre, edad, promedio);

        if (actualizado) {
            System.out.println("Alumno actualizado");
        } else {
            System.out.println("No se pudo actualizar el alumno");
        }
    }

    public static void eliminarEstudiante(){
        while(true){
            System.out.print("\nIngresa la matricula del estudiante: ");
            if(sc.hasNextInt()){
                break;
            }
            sc.next();
            System.out.println("Error, vuelve a intentarlo");
        }
        int m = sc.nextInt();
        if(servicio.eliminarEstudiante(m)){
            System.out.println("Se ha eliminado el registro del estudiante");
            return;
        }
        System.out.println("No existe registro de ese alumno");
    }
}
