public class Samsung extends Device 
{

	public void get()
	{
		System.out.println("Receive Test - " + this.getClass().getName());
	}
	
	public Object set()
	{
		System.out.println("Send Test - " + this.getClass().getName());
		return this;
	}
}