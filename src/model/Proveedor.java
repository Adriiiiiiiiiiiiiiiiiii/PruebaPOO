package model;

public class Proveedor extends Persona {

    private String empresa;

    public Proveedor(String id, String nombre, String empresa) {
        super(id, nombre);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public String getTipo() {
        return "Proveedor";
    }

    @Override
    public String toString() {
        return "Proveedor{id='" + id + "', nombre='" + nombre + "', empresa='" + empresa + "'}";
    }
}
