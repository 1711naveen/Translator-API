package in.naveen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepl.api.TextResult;
import com.deepl.api.Translator;


@RestController
public class TranslationController {
	
	@Value("${translation.api.key}")
	String authKey;
	
	@PostMapping("/translate")
    public ResponseEntity<TranslationResponse> translate(@RequestBody TranslationRequest request) throws Exception {
        if (request.getText() == null || request.getText().isEmpty()) {
            throw new IllegalArgumentException("Text parameter is required");
        }
 
        Translator translator = new Translator(authKey);
        TextResult translation = translator.translateText(request.getText(), "en", "fr");
        TranslationResponse translationResponse = new TranslationResponse(translation.getText());
        return ResponseEntity.ok(translationResponse);
    }
}
