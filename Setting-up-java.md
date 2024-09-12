# Setting Up JDK on Ubuntu

This guide will help you install and manage multiple versions of the Java Development Kit (JDK) on an Ubuntu system. We will cover installing OpenJDK 8, 11, 17, and OpenJDK 22. 

## Prerequisites

- An Ubuntu system
- A terminal with sudo privileges

## 1. Update System Packages

Before installing any software, it's a good idea to update your package list.

```bash
sudo apt update
sudo apt upgrade
```
## 2. Install JDK Versions
### JDK 8
```bash
sudo apt install openjdk-8-jdk
```

### JDK 11
```bash
sudo apt install openjdk-11-jdk
```

### JDK 17
```bash
sudo apt install openjdk-17-jdk
```

### JDK 22

As of this writing, JDK 22 might not be available in the default Ubuntu repositories. You can manually download and install it:

**1. Download the JDK 22 tarball:**

```bash
wget https://download.java.net/java/early_access/jdk22/3/GPL/openjdk-22-ea+3_linux-x64_bin.tar.gz
```

**2. Extract the tarball:**

```bash
tar -xzf openjdk-22-ea+3_linux-x64_bin.tar.gz
```

**3. Move JDK 22 to the appropriate directory:**

```bash
sudo mv jdk-22 /usr/lib/jvm/
```

**4. Update alternatives to include JDK 22:**

```bash
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/
jdk-22/bin/java 4
sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk-22/bin/javac 4
```
## 3. Manage JDK Versions

### Configure Default JDK

Use `update-alternatives` to configure the default JDK:

```bash
sudo update-alternatives --config java
```

You'll see a list of installed Java versions. Enter the number corresponding to the JDK you want to use as the default.

Do the same for the Java compiler:

```bash
sudo update-alternatives --config javac
```

### Verify Installation
Check the installed versions of Java and the Java compiler:

```bash
java -version
javac -version
```

## 4. Set JAVA_HOME Environment Variable
To set the JAVA_HOME environment variable for your current session:

```bash
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
```

To make this change permanent, add the line above to your shell profile file (`~/.bashrc`, `~/.zshrc`, etc.):

```bash
nano ~/.bashrc
```

Add the following line at the end of the file:

```bash
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
```

Save and exit the editor, then reload the profile:

```bash
source ~/.bashrc
```

## 5. Switching Between JDKs

To switch between different JDK versions, use update-alternatives to configure which version to use by default.

```bash
sudo update-alternatives --config java
sudo update-alternatives --config javac
```

## Conclusion

You have now set up and configured multiple JDK versions on your Ubuntu system. You can switch between different versions as needed and set `JAVA_HOME` to point to the version you are currently using.

For more information, visit the [OpenJDK website](https://openjdk.java.net/) or the [Ubuntu documentation](https://help.ubuntu.com/). For more detailed instructions on switching between Java versions, check out my another repository [here](https://github.com/MasterHardik/Java-Learning/blob/main/Switching_java_versions.md).



*Happy coding!*