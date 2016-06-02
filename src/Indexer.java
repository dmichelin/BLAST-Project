import java.util.ArrayList;
/** 
 * 
 * @author Daniel Michelin
 * @version 4/12/2016
 */

public class Indexer {
	int length;
	String file;
	DNASequence sequence;
	ArrayList<DNASequence> data;
	DNADataReader reader;
	ArrayList<SubstringLocs> subLocs;
	public Indexer(int length, String file) {
		
		reader = new DNADataReader(file);
		data = new ArrayList<DNASequence>();
		this.length=length;
		subLocs = new ArrayList<SubstringLocs>();
	}
	
	/**
	 * Constructs an ArrayList of SubstringLocs with unique substrings
	 */
	public void run(){
		data = reader.readData();
		int row = 0;
		for(DNASequence s : data)
		{
			findSubstrings(s,subLocs,row, length);
			row++;
			Debug.println("Sequencing DNA");
		}
		for(SubstringLocs s : subLocs)
		{
			Debug.println(s.toString());
			s.toString();
		}
		
	}
	/** This is a helper method for the run method
	 * 
	 * @param seq The DNA sequence to be analyzed
	 * @param substrings the arraylist of SubstringLocs to check and add to
	 * @param row Whichever DNA sequence was processed
	 * @param length the length of substrings to process
	 */
	private void findSubstrings(DNASequence seq, ArrayList<SubstringLocs> substrings,int row, int length)
	{
		String sequence = seq.sequence();
		int startIndex = 0;
		int endIndex = length;
		// While the start index has not reached the end
		while(endIndex < sequence.length())
		{
			String subString = sequence.substring(startIndex, endIndex);
			//Check the arraylist for a matching substring
			
			boolean found = false;
			
			for(SubstringLocs s : substrings)
			{
				// If the substring has been found in the list
				if(s.substring().equals(subString))
				{
					// Add the location
					s.addLoc(new Locations (row, startIndex,startIndex.length));
					found = true;
				}
			}
			// And if the substring was not found
			if(!found)
			{
				// Add a new substring object with the location in the list
				substrings.add(new SubstringLocs(subString,new Locations(row,startIndex)));
			}
			startIndex = endIndex;
			endIndex=endIndex + length;
		}
	}
	
}
