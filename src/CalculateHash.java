import java.io.File;
import java.io.IOException;

import com.kapsalis.file.FileWalker;


public class CalculateHash 
{
	public static void main (String args[]) throws IOException
	{
		String fileInputDirectory = null;
		
		if (args.length > 0)
		{
			try
			{
				fileInputDirectory = args[0];
			}
			catch(Exception e)
			{
				fileInputDirectory = null;
			}
		}
		
		if (fileInputDirectory == null || fileInputDirectory.equals(""))
		{
			// The path can be defined at this point.
			StringBuilder sb = new StringBuilder();
			sb.append(File.separator);
			sb.append("C:");
			sb.append(File.separator);
			sb.append("temp");
			
			fileInputDirectory = sb.toString();

		}
		
		FileWalker fw = new FileWalker();
		fw.walk( fileInputDirectory );
		
		System.out.println("Done");
	}
}