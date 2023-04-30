JSF lab
---
---
How to run this thing

1. In the folder *'dockerfile-db'* run command <br>
`docker build -t my-mysql .`
2. In the folder with *'docker-compose.yml'* run another command <br>
`docker-compose up`
3. Start *'apache-tomcat-10.\*'* server
4. The application will be available at *localhost:8080/jsf-1.0-SNAPSHOT/clock.html*

<br>

**Note:** The author configured the launch of the apache server in the code editor, so the application artifact moved to the right place automatically
