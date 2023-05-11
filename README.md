# Introduction
This repository contains all the source code of a mobile application for Android developed in Kotlin. The application was created with the purpose of helping the Cáritas de Monterrey foundation so that more people could learn about everything this foundation does and how they can help by donating.

## App Structure
The application consists of three main sections: news display, filter functionality, and the donations and login section. The news display section is fed by an RSS feed from the Cáritas website. Each news item has a title, description, category, and image. The filter functionality allows the user to select the category of any department to display the desired news. The donations and login section allows users to log in to their account to view their donation history. The app has a local database developed with the Room library. It contains the usernames and passwords accepted by our app.

## Installation Instructions
1. Copy the repository URL to clone it.
2. Open Android Studio.
3. Click on the "File" tab, then select "Get from VCS".
4. Paste the repository URL.
5. Click on "Clone".
Please note that in order to run the application, you need to have an emulator installed or use a physical Android device connected directly to your computer.


## Database Configuration
1. Go to the official XAMPP website and download version 8.0.12 from the following link: https://www.apachefriends.org/es/index.html.
2. Navigate to the directory: Applications/XAMPP/xamppfiles/etc/extra/ and open the "httpd-xampp.conf" file.
3. On line number 13, change "Require local" to "Require all granted".
4. Go to Applications/XAMPP/xamppfiles/htdocs and extract the "caritasdb" zip file. Place its folder (found in this repository) in the htdocs directory.
5. Access http://localhost/phpmyadmin/, import the 'CaritasAppDB.sql' database (found in this repository), and set the root user password as 'root'.
6. In the Android application, go to line 28 of the "Login.kt" file and change the IP address to the IP address of your machine. It is important not to use the localhost address (127.0.0.1) as Android Studio tends to have issues with this IP. Preferably, use the local IP address of the device.

## Authors: 
1. Cristóbal Alberto Escamilla Sada
2. Juan Manuel Gómez Ortiz
3. Lucas Eduardo Idígoras
4. Andrés Guerra Ochoa
5. Fernando Doddoli Lankenau					
                                        			
                             			
