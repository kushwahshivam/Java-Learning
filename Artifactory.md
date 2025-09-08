# Artifactory

## Table of Contents
1. [What is Artifactory?](#what-is-artifactory)
2. [Installation](#installation)
3. [Configuration](#configuration)
4. [Using Artifactory](#using-artifactory)
5. [Common Commands](#common-commands)
6. [Storing and Installing Artifacts (e.g., JARs)](#storing-and-installing-artifacts-eg-jars)
7. [Best Practices](#best-practices)
8. [Troubleshooting](#troubleshooting)
9. [References](#references)

## What is Artifactory?

Artifactory is a **binary repository manager** that stores and manages artifacts (binary files) used in your build and release processes. It supports multiple package formats such as Maven, Gradle, Docker, npm, etc.

### Key Features:
- Versioned artifacts
- Repository management
- Integration with CI/CD tools
- Security and access control
- Artifact promotion and distribution

## Installation

### Prerequisites:
- **Java** (for running Artifactory)
- **Docker** (optional, for Docker-based installation)
- **Linux** or **Windows** machine

### Steps to install:
1. Download the Artifactory binary from [JFrog website](https://www.jfrog.com/artifactory/).
2. Follow the instructions for your specific OS.
   - For **Linux**: Run the script to install the Artifactory server.
   - For **Windows**: Run the installer executable.

#### Docker Installation (Optional):
```bash
docker pull jfrog/artifactory-oss
docker run -d -p 8081:8081 jfrog/artifactory-oss
```
## Configuration

### Configure Repositories:

In Artifactory, repositories can be local, remote, or virtual.

Create repositories based on your use case:

- **Local Repository**: Stores locally uploaded artifacts.
- **Remote Repository**: Proxy for external repositories.
- **Virtual Repository**: A group of repositories combined into one endpoint.

### User Authentication & Permissions:

Set up users and roles for managing access.

Artifactory supports integration with **LDAP** and **Active Directory**.

### Network Configuration:

Configure proxies and SSL certificates for secure communication.

## Using Artifactory

### Uploading Artifacts:

- **Upload via UI**: Navigate to the repository and click "Deploy."
- **Upload via CLI**: Use JFrog CLI or other tools like curl.

#### Example using curl:
```bash
curl -u admin:password -T artifact.jar "http://localhost:8081/artifactory/libs-release-local/artifact.jar"
```

### Retrieving Artifacts:

- **Download via UI**: Click on the artifact and choose "Download."
- **Download via CLI**: Using JFrog CLI or curl for automated processes.

#### Example using curl:
```bash
curl -u admin:password -O "http://localhost:8081/artifactory/libs-release-local/artifact.jar"
```

## Common Commands

- **List Repositories**
  ```bash
  curl -u admin:password -X GET "http://localhost:8081/artifactory/api/repositories"
  ```

- **Get Artifact Info**:
  ```bash
  curl -u admin:password -X GET "http://localhost:8081/artifactory/api/storage/libs-release-local/artifact.jar"
  ```
- **Delete Artifact**:
  ```bash
  curl -u admin:password -X DELETE "http://localhost:8081/artifactory/libs-release-local/artifact.jar"
  ```

## Storing and Installing Artifacts (e.g., JARs)

In Artifactory, JAR files and other artifacts are stored in **local repositories**. These artifacts can be uploaded manually or through CI/CD pipelines.

### Uploading JARs to Artifactory

To upload a JAR file to a local repository in Artifactory, you can use the **UI** or **CLI**.

For example, using **curl**:
```bash
curl -u admin:password -T myartifact.jar "http://localhost:8081/artifactory/libs-release-local/myartifact.jar"
```
### Installing Artifacts from Artifactory using Maven

Once the JAR is uploaded to Artifactory, it can be installed into your local Maven repository using the mvn install command. Here's an example of how to install the JAR from Artifactory:

1. Add the repository to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>artifactory</id>
        <url>http://localhost:8081/artifactory/libs-release-local</url>
    </repository>
</repositories>
```

2. Then, install the artifact with Maven:

```bash
mvn install:install-file -Dfile=path-to-your-jar/myartifact.jar -DgroupId=com.example -DartifactId=myartifact -Dversion=1.0.0 -Dpackaging=jar
```

This will install the artifact to your local Maven repository, and you can use it as a dependency in your Maven-based projects.

## Best Practices

- Use **Virtual Repositories** to simplify artifact management.
- Secure your Artifactory instance with proper authentication and authorization settings.
- Integrate Artifactory with **CI/CD pipelines** for automated artifact management.
- **Version your artifacts** for better traceability.

## Troubleshooting

### Common Issues:

- **401 Unauthorized**: Check user permissions and API key.
- **Repository not found**: Ensure that the repository exists and is correctly configured.
- **Slow performance**: Optimize repository settings and check system resources.

For more detailed troubleshooting, visit the [Artifactory documentation](https://www.jfrog.com/confluence/display/JFROG/Artifactory).
