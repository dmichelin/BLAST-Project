import java.util.ArrayList;
import java.util.HashMap;


public class Database
{
	private ArrayList<DNASequence> DNAArray;
	private HashMap<String,SubstringLocs> locMap;
	private ArrayList<SubstringLocs> subLocs;
	
	public Database()
	{
		DNAArray = new ArrayList<DNASequence>();
		locMap = new HashMap<String, SubstringLocs>();
		subLocs = new ArrayList<SubstringLocs>();
	}
	/**
	 *  Sets this internal array to an outside array that contains DNA sequences
	 * @param array
	 */
	public void setArray(ArrayList<DNASequence> array)
	{
		DNAArray = array;
	}
	/** Returns the arraylist of DNA sequences
	 * 
	 * @return Returns this arraylist 
	 */
	public ArrayList<DNASequence> returnArray()
	{
		return DNAArray;
	}
	/** Adds something to the database hashmap
	 * 
	 * @param s The subsequence of n letter characters
	 * @param l the location of which the substring is
	 */
	public void add(String s,SubstringLocs l)
	{
		locMap.put(s, l);
	}
	public void createHashMap(int subLength)
	{
		// First, construct a list of substring locations
		for(DNASequence seq : DNAArray)
		{
			Debug.println("Finding matches for "+ seq.description());
			findMatches(subLength,seq);
		}
		// After constructing the list of substring locations
		Debug.println(""+subLocs.size());
		for (SubstringLocs s : subLocs)
		{
			Debug.println("Checking " + s + "to add to Hashmap");
			Debug.println(""+s.hits());
			//if(s.hits()<=2)
			//{
				Debug.println("Adding "+s+" to hashmap");
				add(s.substring(),s);
			//}
			Debug.println("Checked");
		}
		Debug.println("The size of the hashtable is " +locMap.size());
	}
	/**
	 * helper method to createHashmap. Finds how many hits are in a particular DNA sequence, and also adds new ones to the array
	 * THIS METHOD IS VERY INCOMPLETE
	 */
	public void findMatches(int subLength, DNASequence seq)
	{
		String sequence = seq.sequence();
		int startIndex = 0;
		int endIndex = subLength;
		// Check through each sequence in the array to find a match
		for(DNASequence s: DNAArray)
		{
			Debug.println("loaded "+s);
			// Grab the string of the DNA sequence in question
			String seqToCompare = s.sequence();
			String subString = "q";
			int count = 0;
			while(endIndex<seqToCompare.length())
			{
				Debug.println(""+count++);
				subString= seqToCompare.substring(startIndex, endIndex);
				Debug.println("Comparing "+subString);
				boolean found = false;
				// If this sequence does contain the substring
				if(sequence.contains(subString))
				{
					Debug.println(s +" contains "+subString);
					
					for(SubstringLocs subLoc : subLocs)
					{
						Debug.println("is "+subLoc.substring()+" "+subString);
						
						//if the substring has already been found and documented
						if(subLoc.substring().contentEquals(subString))
						{
							Debug.println("Adding location");
							subLoc.addLoc(new Locations(startIndex,endIndex,s));
							found = true;
						}
						//Otherwise
						
					}
					Debug.println(""+found);
					if(found == false)
						{
							Debug.println("Adding new substring " + subString);
							subLocs.add(new SubstringLocs(subString, new Locations(startIndex,endIndex,s)));
						}
				}
				// If it doesn't contain that substring
				startIndex++;
				endIndex ++;
				
			}
			
		}
	
	}
	public int query(String query)
	{
		int match = 0;
		
		
		if(!(locMap.get(query)==null))
			match++;
			
		
		
		return match;
	}
	
}
