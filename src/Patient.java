import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;  

public class Patient 
{
	public static int last_id = 1; // AUTO ID
	
	private int id;
	private String name;
	private String address = "Unknown";
	private Date birthDate;
	private String password;
	private ConditionInfo condition;
	private Device userDevice;
	
	Patient(String Name)
	{
		this.condition = new ConditionInfo();
		this.id = Patient.generateID();
		this.name = Name;
		
		//Database.getDB().addPatient(this);
	}
	
	static int generateID()
	{
		int give_id = Patient.last_id;
		Patient.last_id += 1;
		return give_id;
	}
	
	
	
	/*
	 *
	 * PATIENT OBJECT
	 * 
	 */
	
	public String getName()
	{
		return this.name;
	}
	
	public Device getDevice()
	{
		return userDevice;
	}
	
	public void setDevice(Device device)
	{
		userDevice = device;
	}
	
	public ConditionInfo getConditions()
	{
		return condition;
	}
	
	public void addCondition(Condition newCondition)
	{
		condition.getInfo().add(newCondition);
	}
	
	
	public void getInfo()
	{
		System.out.println("\n|__________ "+this.name + " __________");

		System.out.println("| _ ID: "+this.id + " - Age: "+this.getAge());
		System.out.println("| _ BirthDate: " + Functions.giveDateString(this.birthDate));

		System.out.println("| _ Condition Info: ");
		for(Condition c : getConditions().getInfo())
		{
			System.out.println("| ----> " + c.name + " " + c.status);
		}
		System.out.println("| _ Address: " + this.getAddress());
		System.out.println("|___________________________\n");
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public int getAge()
	{
		return LocalDateTime.now().getYear() - Functions.ConvertToLocalDateTime(this.getBirthDate()).getYear(); 
	}
	
}