public class Samsung extends Device 
{

	public void get(String data)
	{
		super.receive(data);
	}
	
	public void set(String data)
	{
		super.send(data);
	}
}