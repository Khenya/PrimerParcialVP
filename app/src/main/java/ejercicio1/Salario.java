package ejercicio1;

public class Salario {
    private static final int SALARIO_BASICO = 2000;

    public double calcularDescuento(int salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("El salario no es válido");
        } else if (salario <= SALARIO_BASICO) {
            return salario;
        } else if (salario <= SALARIO_BASICO * 2) {
            return salario - salario * 0.05;
        } else {
            return salario - salario * 0.15;
        }
    }
}
