package com.spring;

class Test2
{

}

public class TestStatic
{
	static
	{
		final int x = 5;
	}
	static int x, y;

	public static void main(final String[] args)
	{
		test5();
	}

	public static void Test1()
	{
		x--;
		myMethod();
		System.out.println(x + y + ++x);
	}

	public static void myMethod()
	{
		y = x++ + ++x;
	}

	public static void test2()
	{
		final char digital = 'a';
		for (int i = 0; i < 100; i++)
		{
			if (i == digital)
			{
				System.out.println(i);
			}

			switch (digital)
			{
			case 'x':
			{
				final int j = 0;
				System.out.println(j);
			}
			default:
			{
				final int j = 100;
				System.out.println(j);
			}
			}

			//			i = j;
			//			System.out.println(i);
		}

	}

	public static void test3()
	{
		System.out.println(Math.round(-11.5));
		System.out.println(Math.round(11.5));
		System.out.println(Math.round(11.3));
		System.out.println(Math.round(11.7));

	}

	public static void test4()
	{
		final int a = 5;
		System.out.println("value is - " + ((a < 5) ? 9.9 : 9));
	}

	public static void test5()
	{
		System.out.println(findHigher(456));
		System.out.println(findHigher(6456));
		System.out.println(findHigher(-456));
		System.out.println(findHigher(45644));
	}

	public static String findHigher(final int n)
	{
		if (n < 10)
		{
			return String.valueOf(n);
		}
		//
		//		if (n / 10 < 10)
		//		{
		//			return String.valueOf(n / 10) + findHigher(n % 10);
		//		}
		//
		//		if (n / 100 < 10)
		//		{
		//			return String.valueOf(n / 100) + findHigher(n % 100);
		//		}
		//
		//		if (n / 1000 < 10)
		//		{
		//			return String.valueOf(n / 1000) + findHigher(n % 1000);
		//		}
		//
		//		if (n / 10000 < 10)
		//		{
		//			return String.valueOf(n / 10000) + findHigher(n % 10000);
		//		}

		return findHigher(n / 10) + n % 10;
	}

	public static void test6()
	{
		final int intTest = 0;

		final Thread t1 = new Thread(new Runnable() {

			public void run()
			{

			}
		});
	}
}
