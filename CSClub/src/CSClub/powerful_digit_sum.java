package CSClub;
 import java.math.BigInteger;

public class powerful_digit_sum {
	public static void main(String args[])
	{
		int best = 0;
		for(int i=99; i>0; i--)
		{
			for(int j=99; j>0; j--)
			{
				BigInteger a = BigInteger.valueOf(i);
				BigInteger g = a.pow(j);
				String b = g.toString();
				int sum = 0;
				for(int k=0; k<b.length(); k++)
				{
					sum += Character.getNumericValue(((b.charAt(k))));
				}
				best = Math.max(best, sum);
			}
		}
		
		System.out.println("Best: "+best);
	}

}
