public class iPhone extends Device
{
	public Object read(Device.DataType dataType)
	{
		Object returner = super.send(dataType);
		
		System.out.println("[ "+dataType.toString()+" RECEIVED FROM "+super.owner.getName()+"'s IPHONE]");
		
		return returner;
	}
	
	public void write(Object p)
	{
		super.receive(p);
	}
}

