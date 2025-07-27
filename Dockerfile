# Use Maven image with JDK
FROM maven:3.8.4-openjdk-17

# Set working directory inside the container
WORKDIR /app

# Copy everything into the container
COPY . .

# Run Maven test
CMD ["mvn", "clean", "test"]