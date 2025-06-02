package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class SolicitudService {
    private List<SolicitudCompra> solicitudes = new ArrayList<>();

    public void registrarSolicitud(SolicitudCompra s) {
        solicitudes.add(s);
    }

    public List<SolicitudCompra> listarSolicitudes() {
        return solicitudes;
    }

    public SolicitudCompra buscarPorNumero(int numero) {
        return solicitudes.stream()
                .filter(s -> s.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }
}
