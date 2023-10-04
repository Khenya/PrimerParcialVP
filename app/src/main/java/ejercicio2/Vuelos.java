package ejercicio2;

public class Vuelos {
    private ServiceVuelos serviceVuelos;

    public Vuelos(){
        serviceVuelos = new ServiceVuelos();
    }

    public Vuelos(ServiceVuelos serviceVuelos) {
        this.serviceVuelos = serviceVuelos;
    }

    public void setServiceVuelos(ServiceVuelos serviceVuelos){
        this.serviceVuelos = serviceVuelos;
    }

    public String reservaVuelo(String destino, int dia, int mes, int gestion, int cantidadPasajes) {
        String diaSemana = serviceVuelos.getDay(dia, mes, gestion);
        String mesString = serviceVuelos.convertirMesString(mes);
        boolean existenPasajes = serviceVuelos.existenPasajes(destino, cantidadPasajes);

        if (existenPasajes) {
            return String.format("el día %s %d %s %d existen %d pasajes para %s", diaSemana, dia, mesString, gestion, cantidadPasajes, destino);
        } else {
            return String.format("no existen suficientes pasajes para %s", destino);
        }
    }

}
