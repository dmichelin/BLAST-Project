// Modified to hold a DNASequence instead of a second integer
public class Locations {
	private int beginning;
	private int end;
	private DNASequence seq;
	
	public Locations(int pos1,int pos2,DNASequence seq)
	{
		this.beginning=pos1;
		this.end = pos2;
		this.seq=seq;
	}
	
	public int beginning()
	{
		return this.beginning;
	}
	
	public DNASequence sequence()
	{
		return this.seq;
	}
	
	public String toString()
	{
		return "("+beginning+","+end+") in " + seq.description();
	}
	
}
