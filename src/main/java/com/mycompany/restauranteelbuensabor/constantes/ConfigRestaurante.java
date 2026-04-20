package com.mycompany.restauranteelbuensabor.constantes;

/**
 * Configuración centralizada del restaurante.
 * contiene todos los valores que no deben cambiar en tiempo de ejecución.
 * Cambiar cualquier valor aquí afecta a todo el sistema automáticamente.
 */
public class ConfigRestaurante {
    
    public static final String NOMBRE = "El Buen Sabor";
    public static final String DIRECCION = "Calle 15 #8-32, Valledupar";
    public static final String NIT = "900.123.456-7";
    
    /** Tasa de IVA según normativa DIAN 2024 */
    public static final double TASA_IVA = 0.19;
    /** Tasa de propina habitual en el sector de restaurantes */
    public static final double TASA_PROPINA = 0.10;
    /** Descuento por volumen: aplica cuando hay más de 3 tipos de productos */
    public static final double TASA_DESCUENTO = 0.05;
    
    /** Umbral mínimo del subtotal para aplicar propina */
    public static final double UMBRAL_PROPINA = 50000;
    /** Cantidad mínima de productos diferentes para aplicar descuento */
    public static final int MIN_ITEMS_DESCUENTO = 3;
}