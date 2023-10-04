package ejercicio1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SalarioTest {

    private final Salario calculadorDescuento = new Salario();

    @ParameterizedTest
    @CsvSource({
            "1500, 1500.0",
            "2500, 2375.0",
            "5000, 4250.0"
    })
    void calcularDescuento(int salario, double descuentoEsperado) {
        double descuento = calculadorDescuento.calcularDescuento(salario);
        Assertions.assertEquals(descuentoEsperado, descuento);
    }

    @ParameterizedTest
    @CsvSource({
            "-100",
            "-500"
    })
    void calcularDescuentoSalarioInvalido(int salario) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                calculadorDescuento.calcularDescuento(salario));
    }
    // @ParameterizedTest
    // @CsvSource({
    //     "1000, 1000.0",
    //     "3000, 2850.0",
    //     "5000, 4750.0",
    //     "0, 0.0"
    // })
    
    // public void verifyNextDay(int s, int descuentoS) {
    //     Salario salario = new Salario();
    //     Double actualSalario = salario.calcularDescuento(s);
    //     Assertions.assertEquals(descuentoS, actualSalario, "El salario no es válido");
    // }
    
}
