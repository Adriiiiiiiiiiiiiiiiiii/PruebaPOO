package service;

import model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorService {
    private List<Proveedor> proveedores = new ArrayList<>();

    public void registrarProveedor(Proveedor p) {
        proveedores.add(p);
    }

    public List<Proveedor> listarProveedores() {
        return proveedores;
    }

    public Proveedor buscarPorId(String id) {
        return proveedores.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}
