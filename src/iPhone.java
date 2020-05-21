
public class iPhone extends Device
{
	public void read()
	{
		System.out.println("Receive Test - " + this.getClass().getName());
	}
	
	public Object write()
	{
		System.out.println("Send Test - " + this.getClass().getName());
		return this;
	}

}

