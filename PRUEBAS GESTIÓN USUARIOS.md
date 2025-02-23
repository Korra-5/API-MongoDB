# Pruebas de gestión de usuarios
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
