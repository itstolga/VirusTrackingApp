// Facade Pattern


import java.util.ArrayList;
import java.util.Date;

import java.time.LocalDateTime;  

public class Patient 
{
	public static int last_id = 1; // AUTO ID
	
	private int id;
	private String name;
	private String address = "Unknown";
	private Date birthDate;
	private String password;
	private Conditions.Fever FeverCondition;

	private Conditions.MuscleAche MuscleCondition;
	private Conditions.RunnyNose NoseCondition;
	private ArrayList<Conditions.Condition> Conditions = new ArrayList<Conditions.Condition>();
	private Device userDevice;
	
	Patient(String name, String birthDate, String address)
	{
		this.id = Patient.generateID();
		this.name = name;
		this.birthDate = Functions.giveDate(birthDate);
		this.address = address;
		
		FeverCondition = new Conditions().new Fever();
		MuscleCondition = new Conditions().new MuscleAche();
		NoseCondition = new Conditions().new RunnyNose();
		
		Conditions.add(FeverCondition);
		Conditions.add(MuscleCondition);
		Conditions.add(NoseCondition);
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
	

	public Conditions.Fever getFeverCondition() {
		return FeverCondition;
	}

	public Conditions.MuscleAche getMuscleCondition() {
		return MuscleCondition;
	}

	public Conditions.RunnyNose getNoseCondition() {
		return NoseCondition;
	}

	
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
	
	
	public ArrayList<Conditions.Condition> getConditions()
	{
		return this.Conditions;
	}
	
	
	public void printConditionInfos()
	{
		for(Conditions.Condition c : getConditions())
		{
			System.out.println(c.getName() + " - " + c.getStatus().toString());
		}
	}
	
	public Date getLastConditionsUpdate() 		// Gets oldest update time from all conditions.
	{
		Date latest = null;
		for(Conditions.Condition c : getConditions())
		{
			if(c.getLastUpdateDate() != null)
				if(latest == null || latest.before(c.getLastUpdateDate())) latest = c.getLastUpdateDate();
		}
		return latest;
	}
	
	public void getInfo()		// Shows all information about patient like a card.
	{
		System.out.println("\n|__________ "+this.name + " __________");

		System.out.println("| _ ID: "+this.id + " - Age: "+this.getAge());
		System.out.println("| _ BirthDate: " + Functions.giveDateString(this.birthDate));

		System.out.println("| _ Condition Info: ");
		for(Conditions.Condition c : this.getConditions())
		{
			System.out.println("| ----> " + c.getName() + " " + c.getStatus().toString());
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