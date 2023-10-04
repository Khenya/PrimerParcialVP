package ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VuelosTest {
    ServiceVuelos serviceVuelosM = Mockito.mock(ServiceVuelos.class);

    @Test
    void verifyReservaVuelo() {
        Mockito.when(serviceVuelosM.existenPasajes("La Paz", 2)).thenReturn(true);
        Mockito.when(serviceVuelosM.getDay(10, 10, 2000)).thenReturn("Lunes");  // Mocked day
        Mockito.when(serviceVuelosM.convertirMesString(10)).thenReturn("Octubre");  // Mocked month

        Vuelos reservaVuelo = new Vuelos();
        reservaVuelo.setServiceVuelos(serviceVuelosM);
        String resultado = reservaVuelo.reservaVuelo("La Paz", 10, 10, 2000, 2);

        String expected = "el día Lunes 10 Octubre 2000 existen 2 pasajes para La Paz";
        Assertions.assertEquals(expected, resultado);

        Mockito.verify(serviceVuelosM).existenPasajes("La Paz", 2);
        Mockito.verify(serviceVuelosM).getDay(10, 10, 2000);
        Mockito.verify(serviceVuelosM).convertirMesString(10);
    }
}
