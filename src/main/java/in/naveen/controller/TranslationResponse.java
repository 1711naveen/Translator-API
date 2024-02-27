package in.naveen.controller;

public class TranslationResponse {
	
	private String translation;

    // Constructors, getters, setters, etc.

    public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public TranslationResponse(String translation) {
        this.translation = translation;
    }

}
