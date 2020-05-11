
public class TestApp {

	public static void main(String[] args) 
	{
		Device User1Device = new Samsung();
		Device User2Device = new iPhone();
		
		User1Device.send();
		User2Device.send();
	}
}
