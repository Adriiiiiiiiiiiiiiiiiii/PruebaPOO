# Práctica de SISTEMA DE GESTIÓN DE COMPRAS ERP

## 📌 Información General

- **Título:** SISTEMA DE GESTIÓN DE COMPRAS ERP
- **Asignatura:** Programacion Orientada a Objetos
- **Carrera:** Ingenieria en ciencias de la computacion
- **Estudiante:** Adriano Rodas
- **Fecha:** 01 / 05 / 2025
- **Profesor:** Ing. Juan Pablo



# Sistema de Gestión de Compras ERP (Consola en Java)

Este sistema simula un entorno básico de gestión de compras en una empresa, incluyendo la administración de proveedores, productos y solicitudes de compra. Desarrollado en Java orientado a objetos.

## Funcionalidades del Menú

```
===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====
1. Registrar proveedor  
2. Registrar producto  
3. Registrar solicitud de compra  
4. Listar proveedores  
5. Listar productos  
6. Listar solicitudes de compra  
7. Buscar proveedor por ID  
8. Buscar producto por nombre  ![img.png](img.png)
9. Buscar solicitud por número  
13. Aprobar / Rechazar solicitud de compra  
14. Calcular total de una solicitud  
15. Salir
```

## Estructura del Proyecto

- **model/**: Clases de dominio (Proveedor, Producto, SolicitudCompra, etc.)
- **service/**: Servicios para gestionar colecciones de objetos.
- **controller/**: Controlador del menú que conecta todo el sistema.
- **Main.java**: Punto de entrada del sistema.

## Características Técnicas

- Uso de abstracción, herencia y polimorfismo.
- Enum para modelar estados de solicitud.
- Uso de listas para almacenamiento en memoria.
- Diseño modular y limpio.
- Interfaz completamente funcional por consola.

## Diagrama UML

![image](https://github.com/user-attachments/assets/d9444708-f377-454e-8842-e1f9270c7ae7)

