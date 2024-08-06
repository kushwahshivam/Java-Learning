# Security and Encryption in Java

This repo provides demonstrations of various security and cryptographic techniques in Java. The examples cover ```hash functions```, ```HMAC```, ```Base64 encoding```, ```encryption algorithms```, ```digital signatures```, and ```key derivation functions```. These techniques are essential for ensuring data integrity, confidentiality, and authentication in modern software applications.



In today’s digital world, securing data and communications is crucial. Java provides a rich set of libraries and APIs for implementing security features. This project showcases different methods for achieving security and encryption in Java:

1. **Hash Functions**: Hash functions convert data into a fixed-size hash value, which is used for data integrity checks and other security purposes.
   - **```MD5```**: Produces a 128-bit hash value, typically rendered as a 32-character hexadecimal number. It’s considered cryptographically broken and unsuitable for further use.
   - **```SHA-1```**: Produces a 160-bit hash value, usually rendered as a 40-character hexadecimal number. It’s more secure than MD5 but has known vulnerabilities.
   - **```SHA-256```**: Part of the SHA-2 family, it produces a 256-bit hash value. It's widely used and considered secure.
   - **```SHA-512```**: Also part of the SHA-2 family, it produces a 512-bit hash value and is used for higher security requirements.

2. **```HMAC``` (Hash-based Message Authentication Code)**: Uses a cryptographic hash function and a secret key to provide message integrity and authentication.

3. **```Base64``` Encoding**: Not a cryptographic technique but often used to encode binary data into a text format. It’s useful for data transfer and storage.

4. **Encryption Algorithms**: Ensure data confidentiality through cryptographic methods.
   - **```AES``` (Advanced Encryption Standard)**: A symmetric key encryption algorithm that is widely used for securing data.
   - **```RSA``` (Rivest-Shamir-Adleman)**: An asymmetric encryption algorithm used for secure data transmission.
   - **```ECC``` (Elliptic Curve Cryptography)**: Provides security equivalent to RSA with shorter key lengths.

5. **Digital Signatures**: Use algorithms like ```RSA``` or ```ECDSA``` (Elliptic Curve Digital Signature Algorithm) to verify the authenticity and integrity of a message.

6. **Key Derivation Functions**: Used to derive cryptographic keys from passwords.
   - **```PBKDF2``` (Password-Based Key Derivation Function 2)**: Used to derive cryptographic keys from passwords.
   - **```bcrypt```**: A key derivation function designed to be slow and resistant to brute-force attacks.
   - **```scrypt```**: A key derivation function designed to be both CPU and memory intensive to thwart brute-force attacks.

## Directory Structure

```bash
.
├── base64
│   └── Base64Demo.java
├── digital-signatures
│   ├── ECDSADemo.java
│   └── RSASignatureDemo.java
├── encryption
│   ├── AESDemo.java
│   ├── ECCDemo.java
│   └── RSADemo.java
├── hash-functions
│   ├── MD5Demo.java
│   ├── SHA1Demo.java
│   ├── SHA256Demo.java
│   └── SHA512Demo.java
├── hmac
│   └── HMACDemo.java
├── key-derivation
│   ├── BcryptDemo.java
│   ├── PBKDF2Demo.java
│   └── ScryptDemo.java
└── README.md
```

## Contents

### Hash Functions

- **```MD5Demo.java```**: Demonstrates MD5 hashing.
- **```SHA1Demo.java```**: Demonstrates SHA-1 hashing.
- **```SHA256Demo.java```**: Demonstrates SHA-256 hashing.
- **```SHA512Demo.java```**: Demonstrates SHA-512 hashing.

### HMAC (Hash-based Message Authentication Code)

- **```HMACDemo.java```**: Demonstrates HMAC using SHA-256.

### Base64 Encoding

- **```Base64Demo.java```**: Demonstrates Base64 encoding and decoding.

### Encryption Algorithms

- **```AESDemo.java```**: Demonstrates AES (Advanced Encryption Standard) encryption and decryption.
- **```RSADemo.java```**: Demonstrates RSA (Rivest-Shamir-Adleman) encryption and decryption.
- **```ECCDemo.java```**: Demonstrates ECC (Elliptic Curve Cryptography) encryption and decryption.

### Digital Signatures

- **```RSASignatureDemo.java```**: Demonstrates RSA digital signatures.
- **```ECDSADemo.java```**: Demonstrates ECDSA (Elliptic Curve Digital Signature Algorithm) digital signatures.

### Key Derivation Functions

- **```PBKDF2Demo.java```**: Demonstrates PBKDF2 (Password-Based Key Derivation Function 2).
- **```BcryptDemo.java```**: Demonstrates bcrypt key derivation.
- **```ScryptDemo.java```**: Demonstrates scrypt key derivation.

## Prerequisites

- Java Development Kit (JDK) 8 or later.
- A compatible Java compiler and runtime environment.

## How to Run

1. **Compile the Java Files:**

   Navigate to the `security-demo` directory and compile the Java files using `javac`. For example:

```bash
cd security-demo
javac hash-functions/*.java hmac/*.java base64/*.java encryption/*.java digital-signatures/*.java key-derivation/*.java
```

2. **Run the Demonstrations:**

    Run the compiled classes using the java command. For example, to run the MD5 demo:
    
    ```bash
    java hash-functions.MD5Demo
    ```
Replace hash-functions.MD5Demo with the appropriate class name for other demonstrations.