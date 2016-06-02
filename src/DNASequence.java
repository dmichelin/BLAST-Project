
public class DNASequence {
	// id is the unique ID for the DNA sequence,
	//desc is the description of the sequence, 
	//and sequence is the actual string of the DNA
	private String id;
	private String desc;
	private String seq;
	/** 
	 * 
	 * @param id This is the ID number of the sequence
	 * @param desc The description of the sequence
	 * @param seq Sequence is the actual string of the DNA
	 */
	public DNASequence(String id, String desc, String seq)
	{
		this.id=id;
		this.desc=desc;
		this.seq=seq;
		
	}
	
	// Getter methods
	
	public String id()
	{
		return id;
	}
	public String description()
	{
		return desc;
	}
	public String sequence()
	{
		return seq;
	}
	/**
	 * Returns the information of the sequence to a string
	 */
	public String toString()
	{
		return "ID: " + id + " Name: " + desc + " Sequence: "+seq;
	}

}
