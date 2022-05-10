**Nombre: MAD CLOTHES**

- **Descripción de la temática**:
  - Tienda de ropa y calzado online.

- **Funcionalidad pública** (Los usuarios no registrados podrán realizar diferentes acciones):

  - Navegación libre a través de la web pudiendo ver ropa.
  - Preguntas frecuentes.
  - Ver stock.
  - Atención al cliente.
  - Loguearte.

- **Funcionalidad privada**(Los usuarios tienen a su disposición toda las funcionalidades de la web):

  - Ver carrito de compra.
  - Historial de compra.
  - Realizar seguimiento del pedido.
  - Bonos descuento.

- **Entidades principales**:
  - Carrito de compra: Listado de productos guardados, pendientes de compra.

  - Oferta: Promociones para productos.
  
  - Pedido:  Entidad la cual es un resumen que incluye los productos, independientemente de los  que el cliente haya comprado, junto con el precio final, la direccion de entrega y la fecha aproximada de entrega.
  
  - Producto: Entidad que representa al objeto que se compra, almacena toda su información, categoría de objeto, talla y modelo.
  
  - Usuario: Persona que utiliza la web y de la que tienes registrados los datos recurrentes de comprar como dirección o nombre y su historial de compra.
  
 - **Diagrama entidades**
<img width="1397" alt="Diagrama Entidades E_R" src="https://user-images.githubusercontent.com/93671942/164419848-97ff8c47-8eb6-4a7a-8c19-0c4a1073aff1.png">

 - **Diagrama de navegacion**
 ![DiagramaDeNavegacion](https://user-images.githubusercontent.com/93671942/164420467-b9cfec3b-7dad-45a8-961e-b8a0afb10b67.png)

- **Funcionalidades del servicio interno**:

     Las funcionalidades del servicio interno están compuestas por distintas funcionalidades como que un usuario puede consultar el stock de un producto, la misma        página mandará correos electrónicos informando a sus usuarios registrados de ofertas, disponibilidad de stock etc. A su vez los usuarios podrán usar la              herramienta valoraciones para dar nota a la ropa.
- **https://github.com/veleto01/ServicioInterno**:
     
- **Instrucciones de instalacion en VM**

   Requerimientos preinstalacion: Se presume que el sistema operativo ya esta instalado con virtualbox.

- **Mysql server JAVA**

   Los 2 archivos jar de la aplicación,servidor y servicio interno compilados desde spring boot (run as mavel desde el boton derecho del raton encima de    cada proyecto)

   Como instalar los componentes si no se tiene instalado mysql server y java.
Mysql server

  - Abrimos el terminal de ubuntu(boton derecho raton→terminal.)

  - Actualizamos los paquetes:

    sudo apt update

  - Instalamos mysql server:

   sudo apt install mysql-server

  - Configuramos mysql server:

   sudo mysql_secure_installation

  - 1º pregunta [intro]

  - 2º pregunta contraseña=”root”(sin las comillas).

  - 3º pregunta y siguientes [intro].

  - Cambiamos el metodo de auntenticacion de root:

   **sudo mysql**

   **SELECT user,authentication_string,plugin,host FROM mysql.user;**

   **ALTER USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY 'root';**

   **FLUSH PRIVILEGES;**

   **SELECT user,authentication_string,plugin,host FROM mysql.user;**

   **exit**

   **JAVA**

  - Actualizamos los paquetes:
  
   sudo apt update

  - Instalamos java:

   sudo apt install default-jre

  - Verificamos la version de la instalación:

   java -version

  - Completando la instalación.

   Estos pasos solo debe completarse la primera vez una vez se tiene instalado mysql y java:

   **mysql -h localhost -u root -p (introducimos root de contraseña).**

   **CREATE DATABASE MADCLOTHES;**

   exit

   Ejecucion final

   Una vez completado lo anterior se recomienda abrirse un editor de texto y crearse un archivo con autoescuelaalpine.sh con el siguiente contenido:
   

 #!/bin/bash
 
 #_*_ENCODING: UTF-8 _*_

 

   De esta manera para ejecutar la app bastaria con hacer ./madclothes.sh si diese error de permiso denegado se le puede dar permisos usando el commando “chmod ugo+rwx madclothes.sh” al archivo, el .sh debe estar en el mismo directorio que los .jar y ejecutarse desde ese directorio.
(https://github.com/veleto01/MAD-CLOTHES/files/8529292/Nombre.docx)

   Para acceder a la web abrimos el navegador con la direccion https://localhost:8443/

  - **Imágenes proyecto**
 **INICIO**
  <img width="259" alt="Captura de pantalla 2022-04-21 a las 11 09 36" src="https://user-images.githubusercontent.com/93671942/164421786-f6654d35-5df8-44f5-b406-1db7c9d3e11c.png">
 
<img width="606" alt="Captura de pantalla 2022-04-21 a las 11 09 51" src="https://user-images.githubusercontent.com/93671942/164421802-8f5548f9-c256-4be0-b851-2f34cfc3ee67.png">
 
<img width="213" alt="Captura de pantalla 2022-04-21 a las 11 10 03" src="https://user-images.githubusercontent.com/93671942/164421827-3026af51-f451-487c-98d7-39<img width="304" alt="Captura de pantalla 2022-04-21 a las 11 10 16" src="https://user-images.githubusercontent.com/93671942/164421968-19bfec7d-ac31-42b0-9924-71acbebcd276.png">
d715b6ad55.png">
 
<img width="342" alt="Captura de pantalla 2022-04-21 a las 11 10 27" src="https://user-images.githubusercontent.com/93671942/164422000-67a892fa-93c5-45dc-b098-a1ae910e4a67.png">

<img width="271" alt="Captura de pantalla 2022-04-21 a las 11 11 02" src="https://user-images.githubusercontent.com/93671942/164422048-7349383b-5985-4257-97ce-fa90a090087e.png">

<img width="817" alt="Captura de pantalla 2022-04-21 a las 11 11 09" src="https://user-images.githubusercontent.com/93671942/164422081-72e95207-c791-4ea4-83d9-3d84f2eaacaa.png">

<img width="800" alt="Captura de pantalla 2022-04-21 a las 11 11 19" src="https://user-images.githubusercontent.com/93671942/164422099-ea02fcfa-34da-49b1-8c93-9fbae04866a0.png">

<img width="262" alt="Captura de pantalla 2022-04-21 a las 11 11 27" src="https://user-images.githubusercontent.com/93671942/164422109-395197ea-5e37-4c97-a033-b6b5319f30df.png">

Diagrama Final
<img width="690" alt="Captura de pantalla 2022-05-10 a las 12 20 34" src="https://user-images.githubusercontent.com/93671942/167607276-67ee2591-8ae0-4927-9523-31d545e34995.png">


 ## Haproxy
  #### - Cargamos el contenedor
  	docker pull haproxytech/haproxy-alpine
  #### - Creamos el Docker file
  	FROM haproxytech/haproxy-alpine:2.0
  	COPY haproxy.cfg /usr/local/etc/haproxy/haproxy.cfg
  #### - Contruimos el contenedor, en la ruta que queramos
  	docker build -t {nombre-contenedor} {ruta}
  #### - Copiamos el archivo haproxy.cfg a la ruta de nuestro contenedor y lo editamos
  	cp /usr/local/etc/haproxy/haproxy.cfg {ruta}
  #### - Archivo haproxy.cfg
  <img width="546" alt="Captura de pantalla 2022-05-10 a las 12 19 10" src="https://user-images.githubusercontent.com/93671942/167607042-986a3f8f-4f97-47f2-95bc-aa2d545eb60e.png">
  #### - Por ultimo arrancamos el contenedor con los puertos correspondientes para la entrada al haproxy, que tenemos especificados en el archivo de configuración
  	docker run --name haproxy -d -v {ruta-archivo.cfg}:/usr/local/etc/haproxy:ro -p 33060:33060 -p 80:80 -p 8443:8443 -p 8404:8404 -p 443:443 haproxytech/haproxy-alpine:2.4
### Crear las webs y los servicios internos
#### Creamos un archivo Dockerfile para cada jar, en el mismo directorio
	FROM adoptopenjdk/openjdk11:latest
	RUN sh -c 'mkdir /usr/app'
	COPY ./{archivo-jar} /usr/app
	ENTRYPOINT ["java", "-jar", "/usr/app/{archivo-jar}"]
#### Construimos el contenedor
	docker build -t david/web1:tag .
#### Iniciamos el contenedor especificando los puertos que queremos parchear
	docker run --name web1 -d -p 8001:80 david/web1:1.1.9
