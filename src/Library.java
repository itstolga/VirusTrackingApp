public interface Library 
{
	Object send(Device.DataType dataType);
	void receive(Object p);
	void getMessage(String message);
}
