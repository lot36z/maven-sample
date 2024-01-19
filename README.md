Java Sample Project

# Build
```bash
./mvnw clean package
```

# Run
```bash
java -cp target/sample-project-1.0-SNAPSHOT.jar com.example.App
```

# Debug
```bash
java -cp target/sample-project-1.0-SNAPSHOT.jar -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y com.example.App
```