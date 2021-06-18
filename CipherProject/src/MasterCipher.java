

public interface MasterCipher {

	/**
	 * Asks the user for a message and checks to make 
	 *      sure it contains only lowercase letters and spaces.
	 *      The String request and validation occur in a loop that 
	 *      only will terminate if the String meets the required criteria.  
	 * @return A String containing only lowercase letters and spaces 
	 */
	public String getMessage(); 
	
	/**
	 * Retrieves four numbers from the user and stores them unto an int array.
	 * The function includes a try catch that ensures that the input is valid.
	 * The function will not return until an array with four valid ints is created.  
	 * @return 
	 */
	public int[] getShift();
	
	/**
	 * Uses the int array and message to encrypt the 
	 *      message and print it out for the user.
	 *      The function should loop through the length of the message
	 *       each letter should apply a shift based on the current index from
	 *       the shifts int array. The shifts int array should cycle back to 0 to avoid bounds errors. 
	 * @return 
	 */
	public String performShift();
	
	/**
	 * @return The encrypted message that should be assigned as a parameter.
	 */
	public String getFinalEncrypt();
}
