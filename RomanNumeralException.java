package convertRomanNumerals;

public class RomanNumeralException extends RuntimeException {

//-----------------------------------------------------------------------------------------------
//	This is a simple, custom Exception class that we use in the Roman2Arabic conversions. This
//	should be an unchecked exception, so it must inherit from RuntimeException.
//-----------------------------------------------------------------------------------------------
	
	public RomanNumeralException (String e) {
//		Call the parent class constructor with the given error message
		super (e);
	}

}
