package net.za.acraig.movefiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyVisitor extends Visitor
	{
	private File _destDir;
	private boolean _move = false; // whether to move files or copy them
	private String _result = "Podcasts listened to this week:\n"; // concatenation of copied filenames
	
	public CopyVisitor(File dest)
		{
		_destDir = dest;
		}
	
	public void setMoveMode(boolean move)
		{
		_move = move;
		}
	
	protected void processFile(final File file)
		{
//		Thread copyThread = new Thread()
//			{
//			public void run()
//				{
//				copyFile(file);
//				if (_move)
//					file.delete();
//				}
//			};
//		copyThread.start();
		
		boolean copyOk = copyFile(file);
		
		if (copyOk)
			_result += file.getName() + "\n";
		if (copyOk && _move)
			file.delete();
		}
	
	private boolean copyFile(File file)
		{
		try
			{
			String destname = _destDir.getAbsolutePath() + File.separator + file.getName();
			File dest = new File(destname);
			if (dest.exists())
				return false;
			
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(dest);
			
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0)
				{
				out.write(buf, 0, len);
				}
			in.close();
			out.close();
			
			boolean succesfulCopy = (file.length() == dest.length());
			return succesfulCopy;
			}
		catch (FileNotFoundException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			} 
		catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return false;
		}
	
	public String getResult()
		{
		return _result;
		}
	}
