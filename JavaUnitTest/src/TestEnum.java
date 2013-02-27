import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Test;

public class TestEnum
{
	@Test
	public void testChainEnum()
	{
		final String[] strs = (String[]) Array.newInstance(String.class, 10);

		System.out.println(Arrays.toString(strs));
	}
}
