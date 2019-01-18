package picoplaca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PlacaTest {
	
	Placa pruebaPlaca;

	@BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void succeedingTest() {
    	// DATOS DE INGRESO
        final String placa = "KEI1576";
        final String fecha = "24/01/2019";
        final String hora = "9:00";
        
        //PRUEBAS
        pruebaPlaca = new Placa(placa, fecha, hora);
        int actual1 = pruebaPlaca.validarPlaca(placa);
        int expected1 = 6;
        boolean actual2 = pruebaPlaca.validarFecha(fecha);
        boolean expected2 = true;
        boolean actual3 = pruebaPlaca.validarHora(hora);
        boolean expected3 = true;
        Assert.assertEquals(actual1, expected1);
        Assert.assertEquals(actual2, expected2);
        Assert.assertEquals(actual3, expected3);
        int actual4 = pruebaPlaca.dayOfWeek(fecha);
        int expected4 = 4;
        boolean actual5 = pruebaPlaca.dentroHorarioPicoPlaca(hora);
        boolean expected5 = true;
        String actual6 = pruebaPlaca.afectaPicoPlaca();
        String expected6 = "\nEl pico y placa No está afecta a tu vehículo";
        Assert.assertEquals(actual4, expected4);
        Assert.assertEquals(actual5, expected5);
        Assert.assertEquals(actual6, expected6);
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
