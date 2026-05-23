package uniquindio.edu.co.parqueadero.model;

public record Reporte(

        int totalVehiculosIngresados,
        double ingresosGenerados,
        double promedioPermanencia,
        String vehiculosMayorTiempo

) {
}