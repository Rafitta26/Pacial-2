# Pacial-2
NOMBRE: RAFAEL AYLLON ZAPATA
# Sistema de Gestión de Empleados

## 1. Información general

Proyecto de examen parcial (Parcial 2) desarrollado en Java. Contiene la implementación de un sistema básico para gestionar empleados con nombre, cargo y salario, además de un ejemplo de aplicación de validación por criterios de negocio y testing de caja negra.

## 2. Autoría y versión

- Autor: [Tu Nombre]
- Fecha: 16 de marzo de 2026
- Versión: 1.0.0

## 3. Estructura de archivos

- `Ejercicio1.java`: clase `Empleado` con atributos `nombre`, `cargo`, `salario`, getters y setters y `toString()`.
- `SistemaGestionEmpleados.java`: clase principal (`main`), clase de gestión `Empleados`, enum `Cargos` y constantes de aplicación.
- `TESTING.md`: análisis de caja negra de los tres atributos (`nombre`, `cargo`, `salario`) con tablas de parámetros, casos válidos y casos no válidos.
- `README.md`: documentación general del repositorio.

## 4. Explicación del código

- `Empleado`: POJO simple que representa un empleado.
- `Cargos`: enum con valores válidos para el cargo y método `fromLabel` para validación case-insensitive.
- `Empleados`: mantiene un array de `Empleado` y ofrece métodos:
  - `darAlta(Empleado)`: inserta en la primera posición libre.
  - `aumentarSalario(double)`: aplica un porcentaje de aumento a todos los empleados existentes.
  - `mostrarListado()`: imprime los empleados en consola.
- `SistemaGestionEmpleados.main`: crea el repositorio, añade empleados de ejemplo, lee un porcentaje y aplica el aumento de salario.

## 5. Validaciones y criterios de aceptación

- Nombre: no nulo, no vacío, al menos dos palabras.
- Cargo: no nulo, no vacío, debe estar en `Cargos` (`Desarrollador`, `Diseñadora`, `Gerente`).
- Salario: no negativo, no por debajo de convenio (convenio asumido 30000 para análisis).

## 6. Testing de caja negra

Ver `TESTING.md` para detalle completo:
- tabla de análisis de parámetros
- casos válidos
- casos no válidos

## 7. Cómo ejecutar

Compilar:

```
javac Ejercicio1.java SistemaGestionEmpleados.java
```

Ejecutar:

```
java SistemaGestionEmpleados
```

Se pedirá porcentaje de aumento y se mostrará el listado actualizado.
