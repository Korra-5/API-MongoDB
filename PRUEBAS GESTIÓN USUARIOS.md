# Pruebas de gestión de usuarios
Aclaraciones:
El campo usuario consta de los siguientes atributos:
    val _id: String?,
    val username: String,
    val password: String,
    val email: String,
    val roles: String = "USER",
    val direccion: Direccion?

Aun así para registrar al usuario encontramos la clase UsuarioRegisterDTO y para realizar el login UsuarioLoginDTO

data class UsuarioRegisterDTO(
    val username: String,
    val email: String,
    val password: String,
    val passwordRepeat: String,
    val rol: String,
    val direccion: Direccion
    )

data class LoginUsuarioDTO(
    val username: String,
    val password: String
    )

## Consultas desde Insomnia
### Registrar Usuario
Nombre de usuario superior a 30 caracteres:

Nombre de usuario inferior a 4 caracteres:

Contraseña inferior a 4 caracteres:

Contraseña superior a 4 caracteres:


Contraseñas no coinciden:


Email no valido:


Municipio no valido:


Provincia no valida


Usuario ya existente


No se pudo conectar con el servidor:


Usuario creado:
1- Se introducen los datos correctos y se le da al boton (Esta cargando)

2- Si todo va bien se borran los campos y sale el mensaje de registro exitoso


### Realizar login

## Consultas desde Interfaz Grafica

### Registrar Usuario
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
