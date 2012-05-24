package net.za.acraig.movefiles;

import java.io.File;

public class CountVisitor extends Visitor 
	{
	private int _count = 0;
	
	protected void processFile(File file)
		{
		_count++;
		}
	
	public final int getCount()
		{
		return _count;
		}
	}
