# Document-search-springboot
SpringBoot project for document searching using opensearch

This is an web application consisting:
- **Backend:** Spring boot + Opensearch (java)
- **Frontend:** Reactjs

## Prerequisites Tools
- Docker Desktop - https://docs.docker.com/desktop/setup/install/windows-install/
- JAVA 17
- Clone the repo https://github.com/garghardik/Document-search-springboot.git

    Backend directory - `document-search/`

    Frontend directory - `app/`

### For sractch project (If not cloned)

Visit - https://start.spring.io/ 

Configure Springboot as - 


| Setting                 | Value                                                                        |
| ----------------------- | ---------------------------------------------------------------------------- |
| **Project Type**        | Maven                                                                        |
| **Language**            | Java                                                                         |
| **Spring Boot Version** | 3.5.6+                                                                       |
| **Packaging**           | Jar                                                                          |
| **Java Version**        | 17+                                                                          |
| **Group**               | `com.javaguides` *(or your choice)*                                 |
| **Artifact**            | `document-search`                                                            |
| **Name**                | `Document Search Service`                                                    |
| **Dependencies**        | Spring Web, Lombok, Spring Boot DevTools |

Generate the .zip file and extract all its components.

## Setting Opesearch Client

- Edit `pom.xml` - Add below code to dependencies
```xml
<dependency>
			<groupId>org.opensearch.client</groupId>
			<artifactId>opensearch-rest-client</artifactId>
			<version>2.6.0</version>
</dependency>
<dependency>
			<groupId>org.opensearch.client</groupId>
			<artifactId>opensearch-java</artifactId>
			<version>2.6.0</version>
</dependency>
```

Make sure to set the versions of both opensearch rest client and java to be equal.

## Run Docker
Run below command in root folder where `docker-compose.yml` is present
```bash
docker-compose up -d
```

To stop containers use:
```bash
docker-compose down
```

Visit http://localhost:9200/ to verify opensearch is up.  

## Run SpringBoot

- If using vscode download `springboot extension pack` from extensions.
- There comes a Spring boot dashboard icon on left panel. Click on it.
- In the `APPS` , you can see your project and click on the run button.
- In the terminal, you can see springboot is running and there is a log verifying the opensearch connection.



# Create React App 

### (If project not cloned)

Run commands - 

```bash
npx create-react-app app
```

### (If cloned)

```bash
npm install
```

To start the application - 
```bash
npm start
```





