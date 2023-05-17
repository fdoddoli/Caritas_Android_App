# Introduction
Developed a mobile application for Android in Kotlin for Cáritas de Monterrey foundation, to showcase what they do and invite people to donate.

# Preview 

**Sign in**

![Iniciar Sesión](https://github.com/fdoddoli/Caritas_Android_App/assets/58672371/04142224-db88-4910-ac56-5321ae6caceb)

**Home**

![Home–Feed](https://github.com/fdoddoli/Caritas_Android_App/assets/58672371/71fe4b37-c0c8-4f8e-8b33-f7b3acecddad)

**Filter**

![Filtro](https://github.com/fdoddoli/Caritas_Android_App/assets/58672371/747d05f9-91ae-4088-aa8f-83feaf21cf51)

**Event**

![Evento-Expandido](https://github.com/fdoddoli/Caritas_Android_App/assets/58672371/ecb7edc3-30a4-4fe7-9e14-c2f2d2ea4cf6)

**Profile**

![Perfil](https://github.com/fdoddoli/Caritas_Android_App/assets/58672371/3de574ff-8ed3-439d-a52d-d858eac1d43b)

# App Structure

The application consists of three main sections: news display, filter functionality, and the donations and login section. The news display section is fed by an RSS feed from the Cáritas website. Each news item has a title, description, category, and image. The filter functionality allows the user to select the category of any department to display the desired news. The donations and login section allows users to log in to their account to view their donation history. The app has a local database developed with the Room library. It contains the usernames and passwords accepted by our app.

# Installation Instructions

1. Copy the repository URL to clone it.
2. Open Android Studio.
3. Click on the "File" tab, then select "Get from VCS".
4. Paste the repository URL.
5. Click on "Clone".
Please note that in order to run the application, you need to have an emulator installed or use a physical Android device connected directly to your computer.


# Database Configuration

1. Go to the official XAMPP website and download version 8.0.12 from the following link: https://www.apachefriends.org/es/index.html.
2. Navigate to the directory: Applications/XAMPP/xamppfiles/etc/extra/ and open the "httpd-xampp.conf" file.
3. On line number 13, change "Require local" to "Require all granted".
4. Go to Applications/XAMPP/xamppfiles/htdocs and extract the "caritasdb" zip file. Place its folder (found in this repository) in the htdocs directory.
5. Access http://localhost/phpmyadmin/, import the 'CaritasAppDB.sql' database (found in this repository), and set the root user password as 'root'.
6. In the Android application, go to line 28 of the "Login.kt" file and change the IP address to the IP address of your machine. It is important not to use the localhost address (127.0.0.1) as Android Studio tends to have issues with this IP. Preferably, use the local IP address of the device.

# Authors: 

1. Cristóbal Alberto Escamilla Sada
2. Juan Manuel Gómez Ortiz
3. Lucas Eduardo Idígoras
4. Andrés Guerra Ochoa
5. Fernando Doddoli Lankenau					
                                        			
                             			
