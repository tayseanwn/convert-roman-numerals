package convertRomanNumerals;

public class RomanNumeral implements Comparable<RomanNumeral>{
	
//-----------------------------------------------------------------------------------------------
//	This class represents a Roman numeral and it must implement Comparable<RomanNumeral>
//	so we can customize how to compare two Roman numerals. The numeral is stored as a String
//	in the object of this class but we want to compare them based on their Arabic value.
//-----------------------------------------------------------------------------------------------

	
	private String numeral;
	
	public RomanNumeral (String numeral) {
//		Initialize the instance variable with the given parameter
		this.numeral = numeral;
	}
	
	public String toString() {
//		Return the numeral value

		return numeral;
	}
	
	public int compareTo (RomanNumeral numeral) {
		
	
//		Compare the Arabic conversion of the two numerals. Return -1 if the "this" one is
//		smaller; 1 if the "this" one is larger; or 0 if they are equal.
		int equal = -1;
		
		String other = numeral.toString();
		
		/*
		 * Using the help of the Roman2Arabic class method: convertWholeNumeral...
		 * 
		 * We are going to present three cases:
		 * 
		 * 1. If this is less than other than return -1
		 * 2. If this is greater than other than return 1 
		 * 3. If this is equal to other than return 0
		 */
		
		// CASE 1: this is less than other
		if (Roman2Arabic.convertWholeNumeral(this.numeral) < Roman2Arabic.convertWholeNumeral(other))
		{
			equal = -1;
		}
		
		// CASE 2: this is greater than other
		else if (Roman2Arabic.convertWholeNumeral(this.numeral) > Roman2Arabic.convertWholeNumeral(other))
		{
			equal = 1;
		}
		
		// CASE 3: this is equal to other
		else if (Roman2Arabic.convertWholeNumeral(this.numeral) == Roman2Arabic.convertWholeNumeral(other))
		{
			equal = 0;
		}
		
		return equal;
		
	}

}
