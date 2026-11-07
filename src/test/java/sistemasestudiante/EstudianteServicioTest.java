package sistemasestudiante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class EstudianteServicioTest {
    @Test 
    void agregarEstudianteCorrectamente(){
        EstudianteServicio servicio = new EstudianteServicio();
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        boolean a = servicio.agregarEstudiante(estudiante);
        assertTrue(a);
        assertEquals(1, servicio.mostrarEstudiantes().size());
    }

    @Test 
    void noAgregarEstudianteDuplicado(){
        EstudianteServicio servicio = new EstudianteServicio();
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        Estudiante estudiante2 = new Estudiante(123, "Dereck", 20, 8.5f);
        assertTrue(servicio.agregarEstudiante(estudiante));
        assertFalse(servicio.agregarEstudiante(estudiante2));
        assertEquals(1, servicio.mostrarEstudiantes().size());
    }

    @Test 
    void buscarEstudianteExistente(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante);
        Estudiante estudianteC = servicio.buscarEstudiante(123);
        assertNotNull(estudianteC);
        assertEquals(estudiante.getMatricula(), estudianteC.getMatricula());
        assertEquals(estudiante.getNombre(), estudianteC.getNombre());
    }

    @Test 
    void buscarEstudianteInexistente(){
        EstudianteServicio servicio = new EstudianteServicio();
        assertNull(servicio.buscarEstudiante(123));
    }

    @Test 
    void buscarEstudianteNoModificadoOriginal(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante);
        Estudiante estudianteE = servicio.buscarEstudiante(123);
        estudianteE.setNombre("Pedro");
        estudianteE = servicio.buscarEstudiante(123);
        assertNotNull(estudianteE);
        assertEquals("Carlos", estudianteE.getNombre());
    }

    @Test 
    void eliminarEstudianteExistente(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante);
        assertTrue(servicio.eliminarEstudiante(123));
        assertEquals(0, servicio.mostrarEstudiantes().size());
        assertNull(servicio.buscarEstudiante(123));
    }

    @Test 
    void eliminarEstudianteInexistente(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante);
        assertFalse(servicio.eliminarEstudiante(223));
        assertEquals(1, servicio.mostrarEstudiantes().size());
    }

    @Test 
    void actualizarEstudianteExistente(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante);
        assertTrue(servicio.actualizarEstudiante(123, "Pedro", 22, 9.0f));
        Estudiante cEstudiante = servicio.buscarEstudiante(123);
        assertNotNull(cEstudiante);
        assertEquals("Pedro", cEstudiante.getNombre());
        assertEquals(22, cEstudiante.getEdad());
        assertEquals(9.0f, cEstudiante.getPromedio(), 0.001f);
    }

    @Test 
    void actualizarEstudianteInexistente(){
        EstudianteServicio servicio = new EstudianteServicio();
        assertFalse(servicio.actualizarEstudiante(123, "Pedro", 22, 9.0f));
    }

    @Test 
    void actualizarEstudianteConDatosInvalidos(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante);
        assertFalse(servicio.actualizarEstudiante(123, "Pedro", -5, 9.0f));
        Estudiante cEstudiante = servicio.buscarEstudiante(123);
        assertNotNull(cEstudiante);
        assertEquals("Carlos", cEstudiante.getNombre());
        assertEquals(20, cEstudiante.getEdad());
        assertEquals(8.5f, cEstudiante.getPromedio(), 0.001f);
    }

    @Test 
    void mostrarEstudiantesDevuelveTodosLosEstudiantes(){
        Estudiante estudiante1 = new Estudiante(123, "Carlos", 20, 8.5f);
        Estudiante estudiante2 = new Estudiante(456, "Luis", 20, 8.5f);
        Estudiante estudiante3 = new Estudiante(789, "Regina", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante1);
        servicio.agregarEstudiante(estudiante2);
        servicio.agregarEstudiante(estudiante3);
        ArrayList<Estudiante> estudianteC = servicio.mostrarEstudiantes();
        assertEquals(3, estudianteC.size());
        estudiante1 = estudianteC.get(0);
        estudiante2 = estudianteC.get(1);
        estudiante3 = estudianteC.get(2);
        assertEquals(123, estudiante1.getMatricula());
        assertEquals(456, estudiante2.getMatricula());
        assertEquals(789, estudiante3.getMatricula());
    }

    @Test
    void mostrarEstudiantesNoModificaListaOriginal(){
        Estudiante estudiante1 = new Estudiante(123, "Carlos", 20, 8.5f);
        Estudiante estudiante2 = new Estudiante(456, "Luis", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante1);
        servicio.agregarEstudiante(estudiante2);
        ArrayList<Estudiante> estudiantesL = servicio.mostrarEstudiantes();
        estudiantesL.remove(0);
        assertEquals(2, servicio.mostrarEstudiantes().size());
    }

    @Test
    void mostrarEstudiantesNoModificaObjetosOriginales(){
        Estudiante estudiante1 = new Estudiante(123, "Carlos", 20, 8.5f);
        EstudianteServicio servicio = new EstudianteServicio();
        servicio.agregarEstudiante(estudiante1);
        ArrayList<Estudiante> estudiantesL = servicio.mostrarEstudiantes();
        Estudiante es1 = estudiantesL.get(0);
        es1.setNombre("Pedro");
        estudiantesL = servicio.mostrarEstudiantes();
        es1 = estudiantesL.get(0);
        assertEquals("Carlos", es1.getNombre());
    }
}