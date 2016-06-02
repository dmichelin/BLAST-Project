import java.util.ArrayList;
import java.util.List;

public class BLAST {
	public static void main(String[] args)
	{
		Debug.turnOn();
		ValidatedInputReader reader = new ValidatedInputReader();
		Database data = new Database();
		
		String filename = reader.getString("Enter the filename of the data you want to analyze", "Data.txt");
		//Number of lines for Viruses.txt is 17
		int length = reader.getInteger("Enter the number of lines for each set of nucleotides", 1, "try again");
		int match = reader.getInteger("Enter the length of the string you want to match", 5, "Please do the thing");
		String queryFile = reader.getString("Enter the file which contains the query", "Queries.txt");
		QueryReader query = new QueryReader(queryFile);
		DNADataReader seqReader = new DNADataReader(filename,length);
		data.setArray(seqReader.readData());
		
		data.createHashMap(match);
		List<String> queries = query.readData();
		for(String s : queries)
		{
			startIndex
			System.out.println(data.query(subQuery));
		}
		
		
		
	}
}
