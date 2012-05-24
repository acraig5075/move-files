package net.za.acraig.movefiles;

import java.io.File;

public abstract class Visitor 
	{
	public void visit(File root)
		{
		if (root != null && root.exists() && root.isDirectory())
			{
			File [] listing = root.listFiles();
			if (listing != null)
				{
				for (File f : listing)
					{
					if (f.isDirectory())
						{
						visit(f);
						processEmptyDir(f);
						}
					else if (f.isFile() && 0 != f.getName().compareTo("empty"))
						processFile(f);
					}
				}
			}
		}

	protected void processEmptyDir(File d)
		{
		}

	protected abstract void processFile(File f);
	}
