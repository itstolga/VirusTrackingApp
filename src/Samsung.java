public class Samsung extends Device 
{
	public Object get(Device.DataType dataType)
	{
		Object returner = super.send(dataType);
		
		System.out.println("[ "+dataType.toString()+" RECEIVED FROM "+super.owner.getName()+"'s SAMSUNG]");
		
		return returner;
	}
	
	public void set(Object p)
	{
		super.receive(p);
	}
}