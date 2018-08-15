package cellPhone;

public class LongDistanceCallReducedRate extends longDistannceCall {
	public LongDistanceCallReducedRate(int c)
	{
		super(c);
	}
	public double getRate()
	{
		return super.getRate()/2.0;
	}
	public String toString()
	{
		return super.toString()+"RR";
	}

}
