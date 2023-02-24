package com.kapsalis.file;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;

import com.kapsalis.utils.Utils;


public class FileWalker 
{
	public void walk( String path)
	{
		File root = new File( path );
		File[] list = root.listFiles();
		
		if (list == null) 
		{
			System.out.println("No files/directories for path [" + path + "]");
			return;
		}
		
		for (File f : list ) 
		{
			if ( f.isDirectory() )
			{
				walk ( f.getAbsolutePath() );
			}
			else
			{
				String a;
				try 
				{
					a = new String(path.getBytes("UTF-8"), Charset.forName("UTF-8"));
					doWork( f.getAbsolutePath() );
				} 
				catch (UnsupportedEncodingException e) 
				{
					e.printStackTrace();
				}
				catch (NoSuchAlgorithmException e) 
				{
					e.printStackTrace();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	private void doWork( String path ) throws NoSuchAlgorithmException, IOException
	{
		StringBuilder sb = new StringBuilder();
		sb.append( path );
		sb.append( "#" ); 
		sb.append( Utils.calculateSHA256( path ) );
		
		System.out.println( sb.toString() );
	}
}
