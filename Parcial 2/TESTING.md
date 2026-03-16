# Testing de caja negra - Clase Empleado

## 1. Análisis de parámetros

Atributo | Tipo | Dominio válido | Restricciones / Criterios de aceptación
--- | --- | --- | ---
`nombre` | String | cualquier texto no vacío y con al menos dos palabras separadas por espacios
 | | | no null, no vacío, longitud > 0, al menos un espacio entre palabras y cada palabra no vacía
`cargo` | String | debe corresponder a uno de los valores definidos en `Cargos`: `Desarrollador`, `Diseñadora`, `Gerente` (case-insensitive)
 | | | no null, no vacío, pertenece al enum `Cargos` usando `Cargos.fromLabel(cargo)`
`salario` | double | valor numérico real
 | | | no null no aplica, no negativo (>=0), no por debajo de convenio salarial (tomado como 30000 para este análisis)

> Nota: Se asume convenio salarial mínimo igual a 30000 (valor de referencia usado en los casos de test). Si el convenio real difiere, ajustar según normativa.

## 2. Casos válidos

ID | `nombre` | `cargo` | `salario` | Resultado esperado
--- | --- | --- | --- | ---
V1 | "Juan Pérez" | "Desarrollador" | 50000 | OK
V2 | "María López" | "Diseñadora" | 45000 | OK
V3 | "Pedro Gómez" | "Gerente" | 60000 | OK
V4 | "Ana María" | "desarrollador" | 30000 | OK (case-insensitive en cargo)
V5 | "Luisa Teresa" | "Gerente" | 30000 | OK (salario en convenio)

## 3. Casos no válidos

ID | `nombre` | `cargo` | `salario` | Falla esperada
--- | --- | --- | --- | ---
N1 | "" | "Desarrollador" | 50000 | nombre vacío
N2 | null | "Diseñadora" | 45000 | nombre null
N3 | "Carlos" | "Gerente" | 60000 | nombre monopalabra (no al menos 2 palabras)
N4 | "Juan " | "Desarrollador" | 50000 | nombre no contiene dos palabras con texto significativo
N5 | "Juan Pérez" | "Tester" | 50000 | cargo no válido (no está en enum)
N6 | "María López" | "" | 45000 | cargo vacío
N7 | "Pedro Gómez" | null | 60000 | cargo null
N8 | "Ana María" | "Gerente" | -1000 | salario negativo
N9 | "Pedro Gómez" | "Gerente" | 25000 | salario por debajo de convenio (30000)
N10 | "Luisa López" | "Desarrollador" | 0 | salario=0 (según criterio no negativo, se acepta, pero validar negocio si se requiere >0)

> Importante: el caso N10 se incluye como frontera no inválida si la política acepta 0; si se exige >0 debe tratarse como no válido.
