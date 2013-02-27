import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class TestConcurrency
{
	private volatile String s;

	@Test
	public void testCollectionCallable()
	{
		final Callable<Object> c = Executors.callable(new Runnable() {

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				System.out.println("the runnable is run.");
			}

		});

		final ExecutorService exec = Executors.newCachedThreadPool();

		final Future<Object> f = exec.submit(c);

		while (!f.isDone())
		{
			System.out.println("callalbe is not finish.");
		}

		System.out.println("callable finished");
		exec.shutdown();
	}
}
