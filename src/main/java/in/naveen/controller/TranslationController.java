package in.naveen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepl.api.TextResult;
import com.deepl.api.Translator;

import in.naveen.error.ErrorResponse;


@RestController
public class TranslationController {
	
	@Value("${translation.api.key}")
	String authKey;
	
	@PostMapping("/translate")
    public ResponseEntity<?> translate(@RequestBody TranslationRequest request) {
        if (request.getText() == null || request.getText().isEmpty()) {
        	ErrorResponse errorResponse = new ErrorResponse("Request body is missing or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
 
        try {
        	Translator translator = new Translator(authKey);
            TextResult translation = translator.translateText(request.getText(), "en", "fr");
            TranslationResponse translationResponse = new TranslationResponse(translation.getText());
            return ResponseEntity.ok(translationResponse);
		} catch (Exception e) {
			ErrorResponse errorResponse = new ErrorResponse("Error during translation: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
        
    }
}
