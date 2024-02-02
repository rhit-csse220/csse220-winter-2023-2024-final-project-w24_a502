package mainApp;

public class InvalidLevelFormatException extends Exception {

    String line;
	
	
	public InvalidLevelFormatException(String line) {
        this.line=line;
	}
	@Override
	public String getMessage() {
		
		return "Invalid format: "+line+ "  does not follow standard format rules(TIME NAME Y-POSITION SIZE ANGLE).";
	}
}