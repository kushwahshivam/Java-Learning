# Switching Between Multiple Java Versions

## Introduction

If you have multiple versions of Java installed on your system, you might need to switch between them depending on the project or application requirements. This guide provides two methods to switch Java versions: using `update-alternatives` and manually setting the `JAVA_HOME` environment variable.

## Method 1: Using `update-alternatives`

The `update-alternatives` tool allows you to manage different versions of software on Debian-based systems (like Ubuntu). You can use it to configure which Java version is used by default.

### Steps

1. **List Installed Java Versions**

   Open a terminal and list all installed Java versions:
   
   ```bash
   sudo update-alternatives --config java
    ```
    Example Output:

    ```bash
    There are 3 choices for the alternative java (providing /usr/bin/java).
    ```
    Selection 
    ```
                    Path                                               Priority   Status
    ---------------------------------------------------------------------------------------
        *0            /usr/lib/jvm/java-11-openjdk-amd64/bin/java        1111      auto mode
        1            /usr/lib/jvm/java-8-openjdk-amd64/bin/java         1081      manual mode
        2            /usr/lib/jvm/java-11-openjdk-amd64/bin/java        1111      manual mode
        3            /usr/lib/jvm/java-17-openjdk-amd64/bin/java        1711      manual mode

        Press <enter> to keep the current choice[*], or type selection number: 
    ```
2. **Select the Desired Version**

    Enter the number corresponding to the Java version you want to use and press Enter. For example, if you want to switch to Java 17:

    ```plaintext
    Press <enter> to keep the current choice[*], or type selection number: 3
    ```

3. **Verify the Change**

To ensure that the correct version is now set as default, check the Java version:

```bash
java -version
```
**Example Output:**

```java
openjdk version "17.0.2" 2022-01-18
OpenJDK Runtime Environment (build 17.0.2+8-Ubuntu-0ubuntu1~20.04)
OpenJDK 64-Bit Server VM (build 17.0.2+8-Ubuntu-0ubuntu1~20.04, mixed mode, sharing)
```

## Method 2: Manually Setting `JAVA_HOME`
If you prefer or need to set a specific Java version manually, you can modify the JAVA_HOME environment variable in your .bashrc file.

### Steps
1. **Find the Installation Path**

    Locate the installation paths of your Java versions. Common locations include `/usr/lib/jvm/` or `/usr/java/`. You can list the directories under `/usr/lib/jvm/` to see the installed versions:

    ```bash
    ls /usr/lib/jvm/
    ```

    **Example Output:**
    ```bash
    java-8-openjdk-amd64  java-11-openjdk-amd64  java-17-openjdk-amd64
    ```
2. **Edit .bashrc**

    Open the `.bashrc` file in a text editor:
    ```bash
    nano ~/.bashrc
    ```
    (Or use your preferred editor.)

3. **Set `JAVA_HOME`**

    Add or modify the `JAVA_HOME` environment variable to point to the desired Java version's installation path. For example, to set Java 17:
    ```bash
    export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
    export PATH=$JAVA_HOME/bin:$PATH
    ```

4. **Apply Changes**

    Save the file and apply the changes by running:

    ```bash
    source ~/.bashrc
    ```
5. **Verify the Change**
    Check the Java version being used:
```bash
java -version
```

**Example Output:**

```java
openjdk version "17.0.2" 2022-01-18
OpenJDK Runtime Environment (build 17.0.2+8-Ubuntu-0ubuntu1~20.04)
OpenJDK 64-Bit Server VM (build 17.0.2+8-Ubuntu-0ubuntu1~20.04, mixed mode, sharing)
```

## Conclusion
You can switch between Java versions either using `update-alternatives` for a system-wide change or by manually setting the `JAVA_HOME` environment variable for user-specific needs. Choose the method that best fits your workflow or project requirements.