public class Device implements Library 
{
	public void receive(String data) {
		System.out.println("Receive Test - " + this.getClass().getName());
		
	}

	@Override
	public void send(String data) {
		System.out.println("Send Test - " + this.getClass().getName());
	}

}
