package com.sleepingdreamlessly.osu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils
{
	public static void unzipToSubfolder(File f, String subfolder)
	{
		try 
		{
	    byte[] buffer = new byte[1024];
	    ZipInputStream zis = new ZipInputStream(new FileInputStream(f));
	    ZipEntry zipEntry = zis.getNextEntry();
	    while(zipEntry != null)
	    {
	      String fileName = zipEntry.getName();
	      File newFile = new File(String.format("%s/%s", subfolder, fileName));
	      FileOutputStream fos = new FileOutputStream(newFile);
	      int len;
	      
	      while ((len = zis.read(buffer)) > 0)
	      {
	        fos.write(buffer, 0, len);
	      }
	      fos.close();
	      zipEntry = zis.getNextEntry();
	    }
	    zis.closeEntry();
	    zis.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
  }
}
