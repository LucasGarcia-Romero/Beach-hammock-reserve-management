
# Umbrella Reservation System

## Descripción del Proyecto
Este proyecto consiste en el desarrollo de un sistema web para la reserva de sombrillas en diferentes playas (A, B y C). Cada sombrilla tiene una capacidad definida para un número específico de personas. El sistema permite a los usuarios autenticados realizar las siguientes acciones:
- **Reservar una sombrilla:** Seleccionando la playa (A, B o C), fecha, hora y el número de personas. Las reservas están disponibles en incrementos de 1 hora entre las 8:00 AM y las 8:00 PM.
- **Cancelar una sombrilla:** Utilizando el identificador único de la sombrilla.
- **Listar sombrillas disponibles:** Mostrando las sombrillas sin reservar para una playa específica en una fecha y hora dadas.

## Arquitectura del Sistema
El proyecto está diseñado como un sistema distribuido dividido en dos componentes principales:

1. **Cliente:**
   - Implementa métodos REST y SOAP para la interacción con el servidor.
   - Cada protocolo (REST y SOAP) tiene su propia implementación independiente.

2. **Servidor:**
   - Proporciona los métodos necesarios para interactuar con la base de datos (reservar, eliminar y listar sombrillas).
   - Se utiliza un archivo `reservations.txt` como base de datos para almacenar las reservas de forma simple.

## Conexión Cliente-Servidor
La comunicación entre el cliente y el servidor se realiza mediante **RMI (Remote Method Invocation)**, lo que permite invocar métodos del servidor desde el cliente, incluso cuando están en aplicaciones separadas.

## Funcionalidades Principales
### 1. Reservar Sombrilla
Permite a los usuarios autenticados seleccionar:
- Playa (A, B o C).
- Fecha y hora (entre 8:00 AM y 8:00 PM, en intervalos de 1 hora).
- Número de personas.

### 2. Cancelar Sombrilla
Permite a los usuarios autenticados cancelar una reserva utilizando el identificador único de la sombrilla.

### 3. Listar Sombrillas Disponibles
Permite a los usuarios autenticados ver todas las sombrillas disponibles en una playa específica en una fecha y hora dadas.

## Requisitos
- Java para la implementación de RMI.
- Frameworks para servicios web REST y SOAP (por ejemplo, JAX-RS y JAX-WS).

## Estructura del Proyecto
```
├── Cliente
│   ├── REST
│   ├── SOAP
│   └── ClientePrincipal.java
├── Servidor
│   ├── RMIServer.java
│   ├── Reservas.java
│   └── reservations.txt
└── README.md
```

## Cómo Ejecutar
1. **Iniciar el servidor:** Ejecuta la clase `RMIServer`.
2. **Seleccionar protocolo cliente:** Decide si usar REST o SOAP, y ejecuta la clase correspondiente.
3. **Probar las funcionalidades:** Autentícate como usuario y realiza acciones como reservar, cancelar o listar sombrillas.

---

¡Disfruta utilizando el sistema de reserva de sombrillas!
