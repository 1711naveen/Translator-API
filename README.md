# Spring Boot Translator API

This Translator API, built with Spring Boot, leverages the DeepI Translate API to provide English to French translation services. It offers a straightforward integration for incorporating language translation functionality into your Spring Boot applications.

## Prerequisites

1. **Get API Key:**
   - Obtain your API key from [DeepI Translate](https://www.deepl.com/translator).

2. **Configuration:**
   - Update the `application.properties` file with your DeepI API key:
     ```properties
     translation.api.key=your_deepi_api_key
     ```

3. **Run the Application:**
   ```bash
   ./mvnw spring-boot:run


## Usage

1. **Translate Text:**
   - **Endpoint:** `http://localhost:8080/translate`
   - **Method:** POST
   - **Request Payload:**
     ```json
     {
         "text": "Hello, how are you?"
     }
     ```
   - **Response:**
     ```json
     {
         "translation": "Bonjour, comment allez-vous ?"
     }
     ```



