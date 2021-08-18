# codefellowship
A website where you can sign up and make a post, that anyone who followed you can see.

### Setup:
To run this app, you should do the following:
+ Clone the repo from here: [https://github.com/AnasAlRamahi/Songr](https://github.com/AnasAlRamahi/Songr).
+ Configure the application.properties file, and name the database 'codefellowship'.
+ Build the project through the IDE (e.g. IntelliJ).
+ Now you can open on the localserver:8080 to see the results.
  *As simple as that :)*


**You should have those dependencies installed(put them in the dependencies in the gradle.build file and then reload the gradle):**

      dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	    implementation 'org.springframework.boot:spring-boot-starter-web'
	    developmentOnly 'org.springframework.boot:spring-boot-devtools'
	    providedRuntime 'org.springframework.boot:spring-boot-starter-tomcat'
	    testImplementation 'org.springframework.boot:spring-boot-starter-test'
	    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	    runtimeOnly 'org.postgresql:postgresql'
	    implementation 'org.springframework.boot:spring-boot-starter-security'
      }

