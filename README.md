# API-MongoDB Gestor de Tareas

Esta aplicación constará de dos colecciones principales:

1. **Colección Usuario**: Almacena las entidades de tipo usuario, con un subdocumento de Dirección para registrar la dirección del usuario.
2. **Colección Tareas**: Almacena las diferentes entidades tipo tareas.

## Diferentes Clases y sus Atributos

### Usuario
- `_id`: BsonId
- `username`: String
- `password`: String
- `roles`: String
- `email`: String
- `direccion`: Direccion
- `tareas`: List

### Dirección
- `municipio`: String
- `provincia`: String
- `calle`: String
- `numero`: String

### Tareas
- `_id`: BsonId
- `titulo`: String
- `descripcion`: String
- `completada`: Boolean
- `fechaCreacion`: Date
- `usuario`: String

## Endpoints

### Endpoints de Usuarios
- `POST/Usuario/register`: Registra nuevos usuarios.
- `POST/Usuario/login`: Autentica usuarios generando un token JWT.

### Endpoints de Tarea
- `GET/Tarea/verTareas`: Ver las tareas del propio usuario (rol USER requerido).
- `UPDATE/Tarea/marcarCompletada/{id}`: Modifica el estado de completado de la tarea (id y rol USER requeridos).
- `DELETE/Tarea/eliminarTarea/{id}`: Elimina una tarea (id requerida; usuarios con rol USER pueden eliminar sus propias tareas; rol ADMIN puede eliminar tareas de cualquier usuario).
- `POST/Tarea/crearTarea`: Añade una nueva tarea (objeto tipo Tarea requerido; usuarios con rol USER pueden añadir sus propias tareas; rol ADMIN puede añadir tareas a cualquier usuario).
- `GET/Tarea/verTodasTareas`: Ver todas las tareas existentes en la base de datos (solo rol ADMIN).

## Lógica de Negocio (Provisional)
- Ningún campo puede ser nulo.
- Existen caracteres mínimos y máximos que varían según el atributo.
- El nombre de usuario debe ser único.
- La contraseña estará hasheada.
- Los roles deben ser USER o ADMIN.
- Las provincias y municipios se verificarán mediante una API externa.

## Excepciones (Provisionales)
- `BadRequestExcepcion`: Datos añadidos incorrectamente.
- `UnauthorizedExcepcion`: Usuarios sin permiso para realizar ciertos endpoints.

## Restricciones de Seguridad
- Excepto register y login, todos los endpoints requerirán un token de seguridad para verificar la identidad del usuario o un rol ADMIN.
- Existen diferentes restricciones según los roles necesarios para utilizar los distintos endpoints.
