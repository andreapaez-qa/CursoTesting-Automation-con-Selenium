package Edit.EjercicioClase1; // Nombre del Paquete al cual pertenece mi archivo

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	String nombreCurso = "Curso de Automatizacion";
    @Test
    public void saludo()
    {
        System.out.println("Hoya " + nombreCurso);
    }
}
