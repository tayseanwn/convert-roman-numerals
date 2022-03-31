package convertRomanNumerals;

public class Roman2Arabic {

//-----------------------------------------------------------------------------------------------
//	This class is used for converting a Roman numeral to its Arabic value (i.e. with the digits 0, 1, 2,…, 9)
//	The class must have no instance variables nor static variables:
//-----------------------------------------------------------------------------------------------

	

	public static int convertSingleNumeral (char value) {
//		Returns the Arabic value of the given character, if it is one of the actual 7 Roman
//		numeral characters. Otherwise, throw a RomanNumeralException.
		
		
		/*
		 * Must be one of the seven Roman characters
		 * I=1, V=5, X=10, L=50, C=100, D=500, and M=1000
		 */
		
		int arabic = -1; // DEFAULT VALUE
		
		if (value == 'I') {
			arabic = 1;
		}
		if (value == 'V') {
			arabic = 5;
		}
		if (value == 'X') {
			arabic = 10;
		}
		if (value == 'L') {
			arabic = 50;
		}
		if (value == 'C') {
			arabic = 100;
		}
		if (value == 'D') {
			arabic = 500;
		}
		if (value == 'M') {
			arabic = 1000;
		}
		
		return arabic;
	}

	


//	Take in a String of a Roman numeral (i.e. "XXIII"), may be an invalid numeral (i.e. VV) in some cases
	public static int convertWholeNumeral(String romanNumeral) throws RomanNumeralException {
	
//		Create a Stack of type Character and use this stack to convert the Roman numeral to its Arabic value.
//		Use push(), pop(), etc. to keep track of the numerals and keep a total of the converted Arabic value.
		
		int total = 0;
		
		
//		int[] romanArray = new int[romanNumeral.length()]; 
		ArrayStack<Character> romanStack = new ArrayStack<Character>(romanNumeral.length()); // create an array with length of string input
	
//		Use the convertSingleNumeral() method to get  Arabic value of a char as you loop through
//		Return the Arabic value if the numeral is valid; otherwise throw a RomanNumeralException

		
		/*
		 * RULES:
		 * I, X, and C, and M can be repeated up to, but not more than, 3 times in a row. 
		 * V, L, and D cannot be repeated at all.
		 * A smaller value immediately before a greater value means we subtract the smaller value from the greater value. 
		 * A larger value immediately before a smaller value means we add the two values together. 
		 * Two consecutive numbers of the same value means we add them together 
		 */
		
		int threeTimes = 0;
		
		for (int i=0; i < romanNumeral.length(); i++) { // use loop to place each char in an array
			
			int current = convertSingleNumeral(romanNumeral.charAt(i));
			char currentRoman = romanNumeral.charAt(i);
			
			if (romanStack.isEmpty()) { //
				romanStack.push(currentRoman);
				total += current;
				
			}
			
			else if (!romanStack.isEmpty()) { // if we have prior items in list
				
				//-----------------------------
				// CASE 1: IF EQUAL (DUPLICATE) - PUSH
				//-----------------------------
				
				// If current character is greater or equal to the top character on the stack, push the
				// current character on stack
				
				if (romanStack.peek() == currentRoman) { // if current and top are the same
					
					
					/*
					 * A. V,L,C Can't repeat, if so then throw RomanNumeralException
					 * B. if I,X,C repreat more then 3 times throwRomanNumeralException
					 * C. if I,X,C used less than 3 times, push but keep track of I,X,C sduplicate
					 * D. if duplicated but if I,X,C or V,L,C are not violated then push and reset track of I,X,C duplicates
					 */
					
					//A
					if (romanStack.peek() == 'V' || romanStack.peek() == 'L' || romanStack.peek() == 'D') {
						throw new RomanNumeralException ("invalid");
					}
					
					
					//B
					else if (threeTimes == 2) {
						threeTimes = 0; //RESTART
						throw new RomanNumeralException ("invalid");
					}
					
					//C
					else if (romanStack.peek() == 'I' || romanStack.peek() == 'X' || romanStack.peek() == 'C') {
						romanStack.push(currentRoman);
						total += current;
						threeTimes++;
					}
					
					//D
					else {
						romanStack.push(currentRoman); // if they are the same but don't break rules
						total += current;
						threeTimes = 0;
					}
				}
				
				//-----------------------------
				// CASE 2: IF GREATER - PUSH
				//-----------------------------
				
				
				
				// If current character is less or equal to the top character on the stack, push the
				// current character on stack
				else if (current < convertSingleNumeral(romanStack.peek())){
					threeTimes = 0;
					romanStack.push(currentRoman);
					total += current;
				}
				
				
				
				
				//-----------------------------
				// CASE 3: IF LESS - POP
				//-----------------------------
				
				// pop off stack and subtract this value from current character and add this to
				// the total
				else { 
					threeTimes = 0;
					char topValueRoman = romanStack.pop(); // keep the roman character value
					int topValueArabic = convertSingleNumeral(topValueRoman); // keep arabic (number)
					
					int newValue = current - topValueArabic;
					romanStack.push(topValueRoman); //since we popped off we have to push back
					romanStack.push(currentRoman); //then we push the current 
					
					
					total -= topValueArabic;
					total += newValue;
				}
			}
			
			
			
		}

		return total;
		
	}
	
	
	//-----------------------------------------------------------------------------------------------
	//	Hint: try hand-tracing this algorithm with a few examples before implementing!
	//	Note: the TestNumerals and TestNumeralList files will be used by Gradescope as part of your marking.
	//	You are also given TestConversions which checks all numerals from 1 to 3999 and determines how many
	//	of those are correct. This particular file is not going to be incorporated into Gradescope for 
	//	your marks, but you are welcome to use it to test that your algorithm works properly for all numbers!
	
	//	Algorithm
	//	Initialize stack
	//		Loop through each character in String starting from the left
	//		Keep track of repeats to see if numeral is invalid (see Invalid Numeral Rules near the top)
	//		If invalid, throw an exception
	//		If stack is empty, push current character on stack
	//		Otherwise,
	//			If current character is greater or equal to the top character on the stack, push the
	//			current character on stack
	//			Otherwise, pop off stack and subtract this value from current character and add this to
	//			the total
	//		Loop through stack and add each item to the total
	//		Return the total
	//-----------------------------------------------------------------------------------------------
	

	
	
}
