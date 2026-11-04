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
                    System.out.println(registrarEstudiante());
                    break;
                case 2:
                    System.out.println("Has seleccionado mostrar estudiantes");
                    break;
                case 3:
                    System.out.println("Has seleccionado buscar estudiante");
                    break;
                case 4:
                    System.out.println("Has seleccionado actualizar estudiante");
                    break;
                case 5:
                    System.out.println("Has seleccionado eliminar estudiante");
                    break;
                case 6:
                    System.out.println("Has seleccionado salir");
                    break;
                default:
                    System.out.println("No se encuentra esa opcion");
            }
            
        }while(op != 6);
    sc.close();
    }
    
    public static String registrarEstudiante(){
        
        System.out.print("Ingresa la matricula: ");
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
                return "Se registro correctamente";
            }return "La matricula ya existe";
        }catch(IllegalArgumentException e){
            return "Error: "+e.getMessage();
        }
    }
    
}
