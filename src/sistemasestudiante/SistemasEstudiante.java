package sistemasestudiante;
public class SistemasEstudiante {
    public static void main(String[] args) {
        EstudianteServicio es1 = new EstudianteServicio();
        Estudiante e1 = new Estudiante(2233, "Dereck", 12, (float)7.88);
        Estudiante e2 = new Estudiante(2244, "David", 13, (float)7.89);
        Estudiante e3 = new Estudiante(2255, "Gisel", 14, (float)7.45);
        
        es1.agregarEstudiante(e1);
        es1.agregarEstudiante(e2);
        es1.agregarEstudiante(e3);
        es1.mostrarEstudiantes();
        
        Estudiante buscar = es1.buscarEstudiante(2244);
        System.out.println(buscar.toString());
        
        System.out.println(es1.actualizarEstudiante(2244, "Regina", 21, (float)9.22));;
        es1.mostrarEstudiantes();
        
        System.out.println("Cambios");
        System.out.println(es1.eliminarEstudiante(2255));;
        System.out.println(es1.buscarEstudiante(2255));;
        System.out.println(es1.eliminarEstudiante(4411));;
    }
    
}
