import java.util.ArrayList;

public class SubstringLocs {
	private ArrayList<Locations> locs;
	private String substring;
	private int hits;
	

	public SubstringLocs(String sub, Locations l)
	{
		locs = new ArrayList<Locations>();
		this.substring=sub;
		hits=1;
		this.locs.add(l);
	}
	
	public void addLoc(Locations l)
	{
		this.locs.add(l);
		hits++;
	}
	public ArrayList<Locations> locations()
	{
		return locs;
	}
	public String substring()
	{
		return substring;
	}
	public String toString()
	{
		//Debug.print("Printing " + substring);
		String s=substring+": ";
		for(Locations l: locs)
		{
			//Debug.println(l.toString());
			s= s+l.toString() + " , ";
		}
		return s;
	}
	public int hits()
	{
		return hits;
	}
}
