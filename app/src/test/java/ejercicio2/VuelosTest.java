package ejercicio2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class VuelosTest {
    ServiceVuelos serviceVuelosM = Mockito.mock(ServiceVuelos.class);

    @Test
    void verifyReservaVuelo() {
        Mockito.when(serviceVuelosM.existenPasajes("La Paz", 2)).thenReturn(true);
        Mockito.when(serviceVuelosM.getDay(10, 10, 2000)).thenReturn("Lunes");  
        Mockito.when(serviceVuelosM.convertirMesString(10)).thenReturn("Octubre");  

        Vuelos reservaVuelo = new Vuelos();
        reservaVuelo.setServiceVuelos(serviceVuelosM);
        String resultado = reservaVuelo.reservaVuelo("La Paz", 10, 10, 2000, 2);

        String expected = "el día Lunes 10 Octubre 2000 existen 2 pasajes para La Paz";
        Assertions.assertEquals(expected, resultado);

        Mockito.verify(serviceVuelosM).existenPasajes("La Paz", 2);
        Mockito.verify(serviceVuelosM).getDay(10, 10, 2000);
        Mockito.verify(serviceVuelosM).convertirMesString(10);
    }

    @Test
    void verifyReservaVueloFail() {
        Mockito.when(serviceVuelosM.existenPasajes("Santa Cruz", 20)).thenReturn(false);
        Mockito.when(serviceVuelosM.getDay(20, 01, 2022)).thenReturn("Martes");  
        Mockito.when(serviceVuelosM.convertirMesString(1)).thenReturn("Enero");  

        Vuelos reservaVuelo = new Vuelos();
        reservaVuelo.setServiceVuelos(serviceVuelosM);
        String resultado = reservaVuelo.reservaVuelo("Santa Cruz", 20, 01, 2022, 20);

        String expected = "no existen suficientes pasajes para Santa Cruz";
        Assertions.assertEquals(expected, resultado);

        Mockito.verify(serviceVuelosM).existenPasajes("Santa Cruz", 20);
        Mockito.verify(serviceVuelosM).getDay(20, 01, 2022);
        Mockito.verify(serviceVuelosM).convertirMesString(01);
    }
}
