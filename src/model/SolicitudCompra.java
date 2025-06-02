package model;

import java.util.ArrayList;
import java.util.List;

public class SolicitudCompra {
    private static int contador = 1;
    private int numero;
    private Proveedor proveedor;
    private List<Producto> productos;
    private EstadoSolicitud estado;

    public SolicitudCompra(Proveedor proveedor) {
        this.numero = contador++;
        this.proveedor = proveedor;
        this.productos = new ArrayList<>();
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public int getNumero() {
        return numero;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void aprobar() {
        estado = EstadoSolicitud.APROBADA;
    }

    public void rechazar() {
        estado = EstadoSolicitud.RECHAZADA;
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    @Override
    public String toString() {
        return "Solicitud #" + numero + ", Proveedor: " + proveedor.getNombre() +
                ", Estado: " + estado + ", Productos: " + productos.size();
    }
}
