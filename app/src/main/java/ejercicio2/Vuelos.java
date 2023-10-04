package ejercicio2;

public class Vuelos {
    private ServiceVuelos serviceVuelos;

    public Vuelos(ServiceVuelos serviceVuelos) {
        this.serviceVuelos = serviceVuelos;
    }

    public String reservaVuelo(String destino, int dia, int mes, int gestion, int cantidadPasajes) {
        String diaSemana = getDay(dia, mes, gestion);
        String mesString = convertirMesString(mes);
        boolean existenPasajes = serviceVuelos.existenPasajes(destino, cantidadPasajes);

        if (existenPasajes) {
            return String.format("El día %s %d %s %d existen %d pasajes para %s", diaSemana, dia, mesString, gestion, cantidadPasajes, destino);
        } else {
            return String.format("No existen suficientes pasajes para %s", destino);
        }
    }

    private String getDay(int dia, int mes, int gestion) {
        // Lógica para obtener el día de la semana
        // Implementa esta lógica según tus necesidades
        // Aquí solo se muestra un ejemplo
        // ...
        return "Lunes";
    }

    private String convertirMesString(int mes) {
        // Lógica para convertir el mes de int a string
        // Implementa esta lógica según tus necesidades
        // Aquí solo se muestra un ejemplo
        // ...
        return "Enero";
    }
}
