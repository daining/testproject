import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestFile
{
	private final String _logDir = "C:/Users/daining/AppData/Roaming/RealPresence CCS";

	@Test
	public void TreeDir()
	{
		final TreeInfo logDirTree = this.resourceDir(new File(_logDir), "*.*");

		System.out.println(logDirTree.toString());
	}

	public File[] local(final File dir, final String regex)
	{
		return dir.listFiles(new FileFilter() {
			private final Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(final File pathname)
			{
				// TODO Auto-generated method stub
				return pattern.matcher(pathname.getName()).matches();
			}

		});
	}

	@Test
	public void testNIO() throws FileNotFoundException, IOException
	{
		final File file = new File("data2.txt");
		if (!file.exists())
		{
			file.createNewFile();
		}
		else
		{
			final BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
			bw.flush();
			bw.close();
		}

		final int BSIZE = 1024;
		final FileChannel fc = new FileOutputStream("data2.txt").getChannel();
		final ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

		fc.write(ByteBuffer.wrap("Test input".getBytes()));
		fc.close();

	}

	public static class TreeInfo implements Iterable<File>
	{
		public ArrayList<File> files = new ArrayList<File>();
		public ArrayList<File> dirs = new ArrayList<File>();

		@Override
		public Iterator<File> iterator()
		{
			// TODO Auto-generated method stub
			return files.iterator();
		}

		public void AddAll(final TreeInfo treeInfo)
		{
			files.addAll(treeInfo.files);
			dirs.addAll(treeInfo.dirs);
		}

		@Override
		public String toString()
		{
			return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);

		}

	}

	public TreeInfo resourceDir(final File dir, final String regex)
	{
		final TreeInfo treeTemp = new TreeInfo();
		for (final File file : dir.listFiles())
		{
			if (file.isFile())
			{
				treeTemp.files.add(file);
			}
			else
			{
				treeTemp.dirs.add(file);
				treeTemp.AddAll(resourceDir(file, regex));
			}
		}

		return treeTemp;
	}
}

class PPrint
{
	public static String pformat(final Collection<?> c)
	{
		if (c.size() == 0)
			return "[]";
		final StringBuilder result = new StringBuilder("[");
		for (final Object elem : c)
		{
			if (c.size() != 1)
				result.append("\n ");
			result.append(elem);
		}
		if (c.size() != 1)
			result.append("\n");
		result.append("]");
		return result.toString();
	}

	public static void pprint(final Collection<?> c)
	{
		System.out.println(pformat(c));
	}

	public static void pprint(final Object[] c)
	{
		System.out.println(pformat(Arrays.asList(c)));
	}
}
