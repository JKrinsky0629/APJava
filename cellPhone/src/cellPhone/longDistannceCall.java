package cellPhone;

public class longDistannceCall extends phoneCall {
	public longDistannceCall(int c)
	{
		super(c);
	}
	public double getRate()
	{
		return 6.0;
	}
	public String toString()
	{
		return super.toString()+" LD";
	}
	

}
