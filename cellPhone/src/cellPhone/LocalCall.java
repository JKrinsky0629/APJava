package cellPhone;

public class LocalCall extends phoneCall {
	private double rate;
	public LocalCall(int c, double r)
	{
		super(c);
		rate =r;
	}
	public double getRate()
	{
		return rate;
	}

}
