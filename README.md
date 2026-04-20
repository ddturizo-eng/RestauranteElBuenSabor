# Restaurante El Buen Sabor

Sistema de facturación para un restaurante desarrollado en Java.

## Descripción

Sistema de gestión de pedidos y facturación para el restaurante "El Buen Sabor". Permite:

- Ver el menú/carta del restaurante
- Agregar productos a un pedido
- Ver el pedido actual
- Generar facturas con cálculo automático de IVA y propina
- Gestionar múltiples mesas

## Reglas de Negocio

- **IVA**: 19% sobre el subtotal
- **Descuento por volumen**: 5% si hay más de 3 tipos de productos diferentes
- **Propina**: 10% si el subtotal supera $50,000

## Estructura del Proyecto

```
src/main/java/com/mycompany/restauranteelbuensabor/
├── modelo/                 # Capa de dominio
│   ├── Producto.java      # Producto del menú
│   ├── ItemPedido.java    # Item en un pedido
│   ├── Pedido.java        # Pedido del cliente
│   └── Carta.java         # Menú del restaurante
├── servicio/              # Lógica de negocio
│   └── CalculadoraFactura.java
├── vista/                 # Presentación
│   └── FacturaView.java
├── constantes/            # Configuración
│   └── ConfigRestaurante.java
├── Datos.java             # Estado global
├── Proceso.java           # Coordinación de procesos
├── Utilidades.java        # Funciones utilitarias
└── RestauranteElBuenSabor.java  # Punto de entrada
```

## Compilación y Ejecución

### Compilar

```bash
javac -d target/classes -sourcepath src/main/java \
  src/main/java/com/mycompany/restauranteelbuensabor/*.java \
  src/main/java/com/mycompany/restauranteelbuensabor/**/*.java
```

### Ejecutar

```bash
java -cp target/classes com.mycompany.restauranteelbuensabor.RestauranteElBuenSabor
```

## Menú del Sistema

```
1. Ver carta
2. Agregar producto al pedido
3. Ver pedido actual
4. Generar factura
5. Nueva mesa
0. Salir
```

## Refactorización

Este proyecto fue refactorizado aplicando los 11 principios de código limpio:

1. **Nombres significativos** - Identificadores descriptivos
2. **SRP** - Responsabilidad única por clase
3. **Comentarios con criterio** - JavaDoc explicando el "por qué"
4. **Código legible** - Formato consistente
5. **Pruebas unitarias** - Cobertura de lógica de negocio
6. **Organización en capas** - Modelo, Servicio, Vista
7. **Consistencia de formato** - Estilo unificado
8. **Evitar hardcoding** - Constantes centralizadas
9. **Funciones breves** - Métodos pequeños y cohesivos
10. **DRY** - Sin duplicación de código
11. **Abierto/Cerrado** - Extensible sin modificar existentes

## Autor

- **Autor**: Daniel David Turizo Chacon
- **Curso**: Programación de Computadores III - PC III SS462
- **Institución**: Universidad Popular del Cesar
- **Docente**: Ing. Alfredo David Bautista Romero

## Versión

1.0 - Sistema de Facturación Refactorizado