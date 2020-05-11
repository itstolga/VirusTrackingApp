public class Device implements Library {

	@Override
	public void receive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void send() {
		System.out.println("Send Test - " + this.getClass().getName());
	}

}
