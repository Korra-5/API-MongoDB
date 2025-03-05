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

# Pruebas de gestión de usuarios

### Aclaraciones:
El campo **usuario** consta de los siguientes atributos:
- `val _id: String?`
- `val username: String`
- `val password: String`
- `val email: String`
- `val roles: String = "USER"`
- `val direccion: Direccion?`

Aun así, para registrar al usuario encontramos las siguientes clases:

#### Registro de Usuario (`UsuarioRegisterDTO`)
- `username: String`  
- `email: String`  
- `password: String`  
- `passwordRepeat: String`  
- `rol: String`  
- `direccion: Direccion`  

#### Login de Usuario (`LoginUsuarioDTO`)
- `username: String`  
- `password: String`  

## Consultas desde Insomnia
### Registrar Usuario
Nombre de usuario superior a 30 caracteres:

![image](https://github.com/user-attachments/assets/0027d95b-eae8-4a82-b797-d5e448046282)

Nombre de usuario inferior a 4 caracteres:

![image](https://github.com/user-attachments/assets/f7293e46-0128-494e-9d92-0eff0e348a5f)

Contraseña inferior a 4 caracteres:

![image](https://github.com/user-attachments/assets/a9857bf4-5348-4d3c-b6e9-35e6e34f65e6)

Contraseña superior a 4 caracteres:

![image](https://github.com/user-attachments/assets/ce7accba-f887-4f69-aa0a-e48bd5a8bc7c)

Contraseñas no coinciden:

![image](https://github.com/user-attachments/assets/800ec9b3-ebae-45e9-a098-08a32577c542)

Email no valido:

![image](https://github.com/user-attachments/assets/091f61a5-64f3-42c0-8934-bd8e82edb6b8)


Municipio no valido:

![image](https://github.com/user-attachments/assets/b95ddfc5-46ed-4c01-91ea-0afb6f11b306)

Provincia no valida

![image](https://github.com/user-attachments/assets/e3530c72-cdab-46e6-9be3-cbdc68589e8c)

Usuario ya existente

![image](https://github.com/user-attachments/assets/b6bdcc67-b5e8-4d86-bb18-c7e886d3e1b2)

Usuario creado:
1- Usuario tipo USER:

![image](https://github.com/user-attachments/assets/c424c247-3fcf-435d-a67a-11725d3ebe3b)

2- Usuario tipo ADMIN:

![image](https://github.com/user-attachments/assets/99e95b00-5ade-4e9a-8b13-a77f2fb9f8a0)

Insercion en la base de datos:

![image](https://github.com/user-attachments/assets/89977a5d-cd3f-4104-8f01-0f6f4059b445)

### Realizar login

Credenciales incorrectas:
1- Usuario

![image](https://github.com/user-attachments/assets/f50e161d-554e-4f16-a9e6-eca4c8e0c8b7)

2- Contraseña

![image](https://github.com/user-attachments/assets/c1336e6d-cb84-418d-abba-d436a058f2ce)

Login exitoso:

![image](https://github.com/user-attachments/assets/7ce03480-8977-4f14-bc87-61b8e5543eff)


## Consultas desde Interfaz Grafica

### Registrar Usuario (En la interfaz un usuario no se puede registrar como ADMIN por motivos de seguridad)
Nombre de usuario superior a 30 caracteres:

![image](https://github.com/user-attachments/assets/6f0ffae0-7278-4959-a0eb-cf8c6433e582)

Nombre de usuario inferior a 4 caracteres:

![image](https://github.com/user-attachments/assets/a1d8fc40-6fbf-461c-9385-cf29d31407cb)

Contraseña inferior a 4 caracteres:

![image](https://github.com/user-attachments/assets/fd5837d2-c460-4592-aa0c-15794a8aae22)

Contraseña superior a 4 caracteres:

![image](https://github.com/user-attachments/assets/a1181f53-a08a-43f9-b9f8-e82a67bd4073)

Contraseñas no coinciden:

![image](https://github.com/user-attachments/assets/64597b19-84d1-42a7-8f14-bef2ee4803d5)

Email no valido:

![image](https://github.com/user-attachments/assets/84a69a14-2c65-45cb-aa9b-58bad05a5e6c)

Municipio no valido:

![image](https://github.com/user-attachments/assets/7d67fe11-637c-479c-ab25-a6ba371143c7)

Provincia no valida

![image](https://github.com/user-attachments/assets/c071dced-8ab4-4c78-8a07-7e8e9cc58956)

Usuario ya existente

![image](https://github.com/user-attachments/assets/25b5924d-5bc8-4907-bc11-dab2147706d7)

No se pudo conectar con el servidor:

![image](https://github.com/user-attachments/assets/fa9770f6-c828-4614-8aff-87e5d8df1ab4)

Usuario creado:
1- Se introducen los datos correctos y se le da al boton (Esta cargando)

![image](https://github.com/user-attachments/assets/8f14283e-83d2-4a13-8ac7-1dc27140c8fe)

Inserción en la base de datos:

![image](https://github.com/user-attachments/assets/2267f59b-d487-44b6-9705-969bb8949f69)


2- Si todo va bien se borran los campos y sale el mensaje de registro exitoso

![image](https://github.com/user-attachments/assets/0cfab6a9-00f1-4fd8-a6ee-f58c55da3f5f)

### Realizar login (El token no se muestra en la interfaz pero se guarda como variable)

Credenciales incorrectas:
1- Usuario

![image](https://github.com/user-attachments/assets/a03f03a0-7ae8-4576-ac0c-621f61c9602d)

2- Contraseña

![image](https://github.com/user-attachments/assets/5d73d7d1-36eb-4fa7-be02-2401675f6134)

Login exitoso:

![image](https://github.com/user-attachments/assets/6b2d8fe6-9bbc-4d2b-aa47-f6020f5ec558)

# Pruebas de gestión de tareas

## Insomnia
### Crear tarea
No existe token de autentificacion:

![image](https://github.com/user-attachments/assets/a34d485a-d036-4a31-95ee-83c831e4712e)

Titulo superior a 30 caracteres:

![image](https://github.com/user-attachments/assets/185d29b0-d849-4a73-8983-968eb2b34cd9)

Descripicon superior a 3000 caracteres

![image](https://github.com/user-attachments/assets/86973da8-d489-44a8-af1f-5fb14e7ef8ad)

Usuario no existe:

![image](https://github.com/user-attachments/assets/5500cd2a-33fd-42b1-b788-d225b3e35571)

Usuario con rol USER no puede crear tareas a otros:

![image](https://github.com/user-attachments/assets/01604cd1-2be4-4ed0-8783-727741616038)

Usuario con rol User puede crear tareas a si mismo

![image](https://github.com/user-attachments/assets/a2a85e37-034b-4f92-8f83-d90f4f1c34a2)

Usuario con rol Admin puede crear tareas a cualquiera

![image](https://github.com/user-attachments/assets/3828b7dd-74d3-40aa-94b6-63c4326be1d3)

### Eliminar tarea

Tarea no existe:

![image](https://github.com/user-attachments/assets/e9a56b87-c54b-4963-8df4-6ae52eb6a50e)

Admin puede eliminar cualquier tarea:

![image](https://github.com/user-attachments/assets/cb02580b-7a6b-4e9a-a1cb-1c96d2eb9e25)

User puede eliminar su propia tarea 

![image](https://github.com/user-attachments/assets/0577c37b-88be-4e2e-aa94-93c79e6f37b9)

![image](https://github.com/user-attachments/assets/870dc99d-29e0-422c-9ab9-c7855f18a650)

User no puede eliminar tarea ajena:

![image](https://github.com/user-attachments/assets/3f710091-3f9e-4743-9c22-c0f4ef6040e8)

![image](https://github.com/user-attachments/assets/9e48891e-31c3-488c-8e36-d6a7be71751c)


### Completar tarea

User no puede completar tareas de otros:

![image](https://github.com/user-attachments/assets/fd2f4662-6fbf-4f03-9da2-19af60df64bc)

Admin puede completar tareas de todos:

![image](https://github.com/user-attachments/assets/cfeec878-b2b1-4f64-a498-7358c6fa6bc2)

Tarea no existe:

![image](https://github.com/user-attachments/assets/ac78ffe1-ae69-40a3-a018-3a78512fb18c)

User puede completar su propia tarea:

![image](https://github.com/user-attachments/assets/1cc5ec19-8366-450d-98c2-78859c473673)

![image](https://github.com/user-attachments/assets/ba1cbb2c-c809-4d09-98d4-a5cbff8ec6f3)

![image](https://github.com/user-attachments/assets/b8d72071-13ca-432e-a684-658c204a9d9c)

No se puede completar una tarea ya completada:

![image](https://github.com/user-attachments/assets/a537b700-0947-4758-a334-251f061d28de)


### Ver tareas
User puede ver sus tareas:

![image](https://github.com/user-attachments/assets/e015b704-a1cf-4221-8155-deef236c0294)

User no puede acceder a tareas ajena:

![image](https://github.com/user-attachments/assets/637e343c-c58d-4fd3-968f-00be68dd3432)

Admin puede ver todas las tareas:

![image](https://github.com/user-attachments/assets/9419c582-9acf-4a8c-8d39-3a69792c51b0)


### Ver todas las tareas
Admin puede acceder:

![image](https://github.com/user-attachments/assets/116b4799-b530-432e-8e8f-76d07c4c54cf)

User no puede acceder:

![image](https://github.com/user-attachments/assets/891c96f5-7676-4e36-9134-c04e2e21966b)
