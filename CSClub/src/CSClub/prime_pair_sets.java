package CSClub;

public class prime_pair_sets {
	public static void main(String args[])
	{
		int[] prime = getPrimes(1000);
		for(int i=0; i< prime.length - 4; i++)
		{
			for(int j = i + 1; j< prime.length - 3; j++)
			{
				for(int k = j + 1; k< prime.length - 2; k++)
				{
					for(int l = k + 1; l< prime.length - 1; l++)
					{
						for(int h = l + 1; h< prime.length; h++)
						{
							
								
						}	
					}	
				}	
			}
		}
	}
	public static int[] getPrimes(int a)
	{
		int cnt =0;
		int i=0;
		int[] array = new int [a];
		while(cnt < a)
		{
			boolean is_prime = true;
			for(int j=2; j< 1; j++)
			{
				if(i%j == 0)
				{
					is_prime = false;
					break;
				}
			}
			if(is_prime)
			{
				array[cnt]=i;
				cnt++;
			}
			i++;
		}
		return array;
	}

}
