package net.za.acraig.movefiles;

import java.io.File;

public class DeleteVisitor extends Visitor
	{
	public DeleteVisitor()
		{
		}
	
	@Override
	protected void processEmptyDir(File d)
		{
		d.delete();
		}

	@Override
	protected void processFile(File f)
		{
		f.delete();
		}

	}
