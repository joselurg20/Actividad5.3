import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));

    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("Sumas")
    void testSumas() throws Exception{
        assertEquals(3, miCalculadora.suma(-5,8));
        assertEquals(13, miCalculadora.suma(5,8));
        assertEquals(-24, miCalculadora.suma(45,-69));
        assertEquals(8.53, miCalculadora.suma(2.63,5.9), 0.0000000001);

    }

    @Test
    @DisplayName("Restas")
    void testRestas() throws Exception{
        assertEquals(0, miCalculadora.resta(5,5));
        assertEquals(13, miCalculadora.resta(5,-8));
        assertEquals(-15, miCalculadora.resta(-6,9));
        assertEquals(1.6, miCalculadora.resta(5.5,3.9));
    }

    @Test
    @DisplayName("Potencia")
    void testPotencia () throws Exception{
        assertEquals(25, miCalculadora.potencia(5,2));
        assertEquals(1, miCalculadora.potencia(3, 0));
        assertEquals(16, miCalculadora.potencia(2,4));
        assertEquals(64, miCalculadora.potencia(4,3));
    }
    @Test
    @DisplayName("Raices cuadradas")
    void testRaices () throws Exception {
        assertEquals(8, miCalculadora.raizCuadrada(64));
        assertEquals(9, miCalculadora.raizCuadrada(81));
        assertEquals(1, miCalculadora.raizCuadrada(1));
        assertEquals(0, miCalculadora.raizCuadrada(0));
}

}