package sistemasestudiante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstudianteTest {
    @Test
    void crearEstudianteConDatosValidos(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 8.5f);
        assertEquals(123, estudiante.getMatricula());
        assertEquals("Carlos", estudiante.getNombre());
        assertEquals(20, estudiante.getEdad());
        assertEquals(8.5f, estudiante.getPromedio(), 0.001f);
    }

    @Test
    void noCrearEstudianteConMatriculaInvalida(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(0, "Carlos", 20, 8.5f);});
    }

    @Test 
    void noCrearEstudianteConNombreNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(123, null, 20, 8.5f);});
    }

    @Test
    void noCrearEstudianteConNombreVacio(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(123, "", 20, 8.5f);});
    }
    @Test 
    void noCrearEstudianteConNombreDeEspacios(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(123, "   ", 20, 8.5f);});
    }

    @Test 
    void noCrearEstudianteConEdadCero(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(123, "Carlos", 0, 8.5f);});
    }

    @Test 
    void noCrearEstudianteConEdadNegativa(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(123, "Carlos", -5, 8.5f);});
    }

    @Test 
    void limiteInferior(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 0.0f);
        assertEquals(0.0f, estudiante.getPromedio(), 0.001f);
    }

    @Test 
    void limitesuperior(){
        Estudiante estudiante = new Estudiante(123, "Carlos", 20, 10.0f);
        assertEquals(10.0f, estudiante.getPromedio(), 0.001f);
    }

    @Test 
    void debajoDelLimite(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(123, "Carlos", 20, -0.1f);});
    }

    @Test 
    void encimaDelLimite(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Estudiante(123, "Carlos", 20, 10.1f);});
    }
}
