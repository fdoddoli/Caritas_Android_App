# Caritas Android App
Este repositorio contiene todo el código fuente de una aplicación móvil para Android desarrollada en kotlin. La aplicación se hizo con el propósito de ayudar a la fundación Cáritas de monterrey a que más personas conocieran todo lo que hace esta fundación y como pueden ayudarlas donando.

This repository contains all the source code of a mobile application for Android developed in Kotlin. The application was created with the purpose of helping the Cáritas de Monterrey foundation so that more people could learn about everything this foundation does and how they can help by donating.

## Estructura de la App 
La aplicación está compuesta de tres secciones principales: la visualización de noticias, la funcionalidad del filtro y la sección de donaciones e inicio de sesión. La visualización de noticias se alimenta de un archivo RSS de la página web de Cáritas. Cada noticia tiene un título, una descripción, categoría e imagen. La funcionalidad del flitro permite al usuario seleccionar la categoría de cualquier departamento para desplegar las noticias deseadas. La sección de donaciones e inicio de sesión permite que los usuarios puedan login a su cuenta para poder visualizar su historial de donaciones. La app cuenta con una base de datos local, desarrollada con la librería Room. Ahí se encuentran los usuarios y contraseñas que acepta nuestra app.

The application consists of three main sections: news display, filter functionality, and the donations and login section. The news display section is fed by an RSS feed from the Cáritas website. Each news item has a title, description, category, and image. The filter functionality allows the user to select the category of any department to display the desired news. The donations and login section allows users to log in to their account to view their donation history. The app has a local database developed with the Room library. It contains the usernames and passwords accepted by our app.

## Instrucciones de instalación 
1.	Copiar el url del repositorio para poder clonarlo. 
2.	Abrir Android estudio 
3.	Hacer click en la pestaña de archivo > “Get from VCS”
4.	Insertar el url del repositorio 
5.	Hacer click en clonar 
Recuerde que para ejecutar la aplicación necesita tener un emulador instalado o usar un dispositivo físico de Android, conectado directamente a su computadora. 

1. Copy the repository URL to clone it.
2. Open Android Studio.
3. Click on the "File" tab, then select "Get from VCS".
4. Paste the repository URL.
5. Click on "Clone".
Please note that in order to run the application, you need to have an emulator installed or use a physical Android device connected directly to your computer.


## Configuracion para la base de datos
1. Ir a la pagina oficial de XAMPP y descargar la version 8.0.12 (https://www.apachefriends.org/es/index.html)
2. Entrar al directorio: Applications/XAMPP/xamppfiles/etc/extra/ y abrir el archivo "httpd-xampp.conf"
3. En la linea número 13: cambiar "Require local" a "Require all granted"
4. Entrar a Applications/XAMPP/xamppfiles/htdocs y extraer el zip "caritasdb" y colocar su carpeta (se encuentra en este repositorio)
5. Entrar a http://localhost/phpmyadmin/, importar la base de datos 'CaritasAppDB.sql' (se encuentra en este repositorio) y establecer contraseña del usuario root como 'root'
6. Dentro de la aplicación de Android, en la línea 28 del archivo "Login.kt", cambiar la dirección IP a la dirección ip de su máquina. Es importante que no se utilice la dirección de localhost (127.0.0.1) ya que Android Studio tiende a tener problemas con esta IP, de preferencia utilizar la dirección local del dispositivo.

1. Go to the official XAMPP website and download version 8.0.12 from the following link: https://www.apachefriends.org/es/index.html.
2. Navigate to the directory: Applications/XAMPP/xamppfiles/etc/extra/ and open the "httpd-xampp.conf" file.
3. On line number 13, change "Require local" to "Require all granted".
4. Go to Applications/XAMPP/xamppfiles/htdocs and extract the "caritasdb" zip file. Place its folder (found in this repository) in the htdocs directory.
5. Access http://localhost/phpmyadmin/, import the 'CaritasAppDB.sql' database (found in this repository), and set the root user password as 'root'.
6. In the Android application, go to line 28 of the "Login.kt" file and change the IP address to the IP address of your machine. It is important not to use the localhost address (127.0.0.1) as Android Studio tends to have issues with this IP. Preferably, use the local IP address of the device.

## Autores: 
1. Cristóbal Alberto Escamilla Sada - Desarrollo de perfil y base de datos
2. Juan Manuel Gómez Ortiz - Desarrollo de front end / conexión a bd mediante servidor
3. Lucas Eduardo Idígoras - Lectura de datos desde la pagina de Cáritas
4. Andrés Guerra Ochoa - Pruebas
5. Fernando Doddoli Lankenau - Desarrollo de front end						
                                        			
                             			
