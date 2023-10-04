package ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VuelosTest {
    ServiceVuelos serviceVuelosM = Mockito.mock(ServiceVuelos.class);

    @Test
    public void verifyReservaVuelo() {
        Mockito.when(serviceVuelosM.existenPasajes("La Paz", 2)).thenReturn(true);
        // Mockito.when(serviceVuelosM.existenPasajes("Santa Cruz", 5)).thenReturn(false);
        // Mockito.when(serviceVuelosM.existenPasajes("Potosi", 0)).thenReturn(true);

        Vuelos reservaVuelo = new Vuelos();
        reservaVuelo.setServiceVuelos(serviceVuelosM);
        String resultado = reservaVuelo.reservaVuelo("La Paz", 10, 10, 2000, 10);

        String expected = "El día Lunes 29 Mayo 2023 existen 2 pasajes para La Paz";
        Assertions.assertEquals(expected, resultado);
    }
}