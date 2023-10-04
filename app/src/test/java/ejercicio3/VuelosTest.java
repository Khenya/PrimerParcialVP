package ejercicio3;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VuelosTest {

    private MockedStatic<ServiceVuelos> mockedServiceVuelos;
    private ServiceVuelos serviceVuelosMock;

    @BeforeAll
    void setUp() {
        mockedServiceVuelos = Mockito.mockStatic(ServiceVuelos.class);
        serviceVuelosMock = Mockito.mock(ServiceVuelos.class);
        
        // Mock the behavior of the instance method
        Mockito.when(serviceVuelosMock.existenPasajes("La Paz", 2)).thenReturn(true);
        Mockito.when(serviceVuelosMock.getDay(10, 10, 2000)).thenReturn("Lunes");
        Mockito.when(serviceVuelosMock.convertirMesString(10)).thenReturn("Octubre");
        
        // Mock the static method to return the mocked instance
        mockedServiceVuelos.when(ServiceVuelos::new).thenReturn(serviceVuelosMock);
    }

    @AfterAll
    void tearDown() {
        mockedServiceVuelos.close();
    }

    @Test
    void verifyReservaVuelo() {
        Vuelos reservaVuelo = new Vuelos(serviceVuelosMock);
        String resultado = reservaVuelo.reservaVuelo("La Paz", 10, 10, 2000, 2);

        String expected = "el día Lunes 10 Octubre 2000 existen 2 pasajes para La Paz";
        Assertions.assertEquals(expected, resultado);
    }
    @Test
    void verifyReservaVuelofail() {
        Vuelos reservaVuelo = new Vuelos(serviceVuelosMock);
        String resultado = reservaVuelo.reservaVuelo("La Paz", 10, 10, 2000, 2);

        String expected = "el día Lunes 10 Octubre 2000 existen 2 pasajes para La Paz";
        Assertions.assertEquals(expected, resultado);
    }

}
