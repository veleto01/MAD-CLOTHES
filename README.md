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

 - **Diagrama entidades**
 
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

