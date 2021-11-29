# CaritasRetoActual
Este repositorio contiene todo el código fuente de una aplicación móvil para Android desarrollada en kotlin. La aplicación se hizo con el propósito de ayudar a la fundación Cáritas de monterrey a que más personas conocieran todo lo que hace esta fundación y como pueden ayudarlas donando.

## Estructura de la App 
Está compuesta de 3 secciones principales, la visualización se noticias, se alimenta de un archivo RSS de la página web de Cáritas. Procesamos toda esta información para desplegarla en nuestra aplicación. Cada noticia tiene un título, una descripción, categoría e imagen.
Por otro lado tenemos la funcionalidad de filtro, el usuario puede seleccionar la categoría de cualquier departamento para desplegar las noticias deseadas. 
Por último, tenemos la sección de donaciones e inicio de sesión. La app cuenta con una base de datos local, desarrollada con la librería room. Ahí se encuentran los usuarios y contraseñas que acepta nuestra app. Al iniciar sesión el usuario tiene la posibilidad de visualizar todas las donaciones que haya realizado.

## Instrucciones de instalación 
1.	Copiar el url del repositorio para poder clonarlo. 
2.	Abrir Android estudio 
3.	Hacer click en la pestaña de archivo > nuevo > “Project from versión control”
4.	Insertar el url del repositorio 
5.	Hacer click en clonar 
Recuerde que para ejecutar la aplicación necesita tener un emulador instalado o usar un dispositivo físico de Android, conectado directamente a su computadora. 
## Configuracion para la bade de datos
1. Ir a la pagina oficial de XAMP y descargar la version 8.0.12 (https://www.apachefriends.org/es/index.html)
2. Entrar al directorio: Aplications/XAMPP/xamppfiles/etc/extra/ y abrir el archivo "httpd-xampp.conf"
3. En la linea número 13: cambiar "Require local" a "Require all granted"
4. Entrar a Applications/XAMPP/xamppfiles/htdocs y meter la carpeta "caritasdb"
5. Entrar a http://localhost/phpmyadmin/, importar la base de datos 'CaritasAppDB' y establecer contraseña del usuario root como 'root'



## Autores: 
1. Cristóbal Alberto Escamilla Sada - Desarrollo y conexion con la base de datos
2. Juan Manuel Gómez Ortiz - Desarrollo de back end
3. Lucas Eduardo Idígoras - Lectura de datos desde la pagina de Cáritas
4. Andrés Guerra Ochoa - 
5. Fernando Doddoli Lankenau - Desarrollo de front end						
                                        			
                             			