
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Alyssa Zhao
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for(int i = 0; i< size; i++){
			myWords[i] = source[start];
			start++;
		}
		myToString = "";
		myHash = 0;

		// TODO: initialize all instance variable
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Returns the size of the WordGram
	 * @return length of myWords instance variable of WordGram
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	/**
	 * Compares two WordGrams to determine if they have the same strings in the same order as one another
	 * @param o object to be compared
	 * @return if the two WordGram objects are equal or not
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		if(this.myWords.length != wg.myWords.length){
			return false;
		}
		for(int i = 0; i< this.myWords.length; i++){
			if(!this.myWords[i].equals(wg.myWords[i])){
				return false;
			}
		}
		// TODO: Complete this method

		return true;
	}

	/**
	 * Determines hashcode of a WordGram object
	 * @return the hashcode value of the WordGram
	 */
	@Override
	public int hashCode(){
		// TODO: complete this method: assign to myHash as needed
		if(myHash == 0){
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Creates a new WordGram object where the other entries are shifted to add a new entry at the end
	 * @param last is last String of returned WordGram
	 * @return new WordGram object with the shifted and added String parameter last
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method
		for(int i = 0; i < myWords.length-1; i++){
			wg.myWords[i] = this.myWords[i+1];
		}
		wg.myWords[myWords.length-1] = last;
		return wg;
	}

	/**
	 * Create and print a string of the WordGram value
	 * @return the string value of the WordGram
	 */
	@Override
	public String toString(){
		// TODO: Complete this method, assign to myToString as needed
		if(myToString.length() == 0){
			myToString = String.join(" ", myWords);
		}

		return myToString;
	}
}
