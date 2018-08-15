package cellPhone;

import java.util.ArrayList;

public abstract class phoneCall {
	private int duration;
	private static int seqCnt=0;
	private int seq;
	
	public phoneCall(int a)
	{
		duration = a;
		seq = seqCnt++;
	}
	public void setDuration(int a)
	{
		duration = a;
	}
	public abstract double getRate();
	
	private int getCost()
	{
		return (int)(duration * getRate());
	}
	public String toString()
	{
		return " SN: "+seq+" Duration: "+duration+" Rate: "+getRate()+" Cost: "+getCost();
	}
	
	public static void main(String args[])
	{
		ArrayList<phoneCall> calls = new ArrayList<phoneCall>();
		calls.add(new LocalCall(10, 2.5));
		calls.add(new longDistannceCall(3));
		calls.add(new LongDistanceCallReducedRate(8));
		for (phoneCall call: calls) {
		 System.out.println(call);
		}
	}

}
