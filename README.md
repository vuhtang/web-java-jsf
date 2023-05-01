JSF lab
---
---
How to run this thing
1. Build project with Gradle
2. Run commands to set up dependencies for js <br>
`npm install` <br>
`npm run build`
3. In the folder *'dockerfile-db'* run command <br>
`docker build -t db-mysql .`
4. Run another command to set up a database <br>
`docker-compose up`
5. Build artifact and deploy it on the *'apache-tomcat-10.\*'* server
6. The application will be available at *localhost:8080/jsf-1.0-SNAPSHOT/clock.xhtml*

<br>

**Note:** The author configured the launch of the apache server in the code editor, so the application artifact moved to the right place automatically
