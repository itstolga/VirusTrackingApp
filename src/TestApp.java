import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TestApp 
{
	
	static void AddDevices()
	{
		Device newDevice = new DeviceAdapter(new Samsung()); // New User installed app.
		Patient newPatient = new Patient("Burak Saraç","11.09.1986","Sipahiler Sokak Balçova Ýzmir"); // Created new patient
		newPatient.setDevice(newDevice); // Assign device as patient's device at database
		newPatient.getFeverCondition().Update(Conditions.ConditionStatus.Critic); // Update condition
		newDevice.receive(newPatient); // Send updated patient data to phone.
		Database.getDB().addDevice(newDevice); // Add new device to database.
		
		newDevice = new DeviceAdapter(new Samsung()); // New User installed app.
		newPatient = new Patient("Tolga Yavuz","26.11.1985","Sakarya Cad. Balçova Ýzmir"); // Created new patient
		newPatient.setDevice(newDevice); // Assign device as patient's device at database
		newPatient.getFeverCondition().Update(Conditions.ConditionStatus.Normal); // Update condition
		newPatient.getMuscleCondition().Update(Conditions.ConditionStatus.Critic); // Update condition
		newDevice.receive(newPatient); // Send updated patient data to phone.
		Database.getDB().addDevice(newDevice); // Add new device to database.
		
		newDevice = new DeviceAdapter(new iPhone()); // New User installed app.
		newPatient = new Patient("Eren Önem","05.05.1987","Tolga Sokak Balçova Ýzmir"); // Created new patient
		newPatient.setDevice(newDevice); // Assign device as patient's device at database
		newPatient.getFeverCondition().Update(Conditions.ConditionStatus.Normal); // Update condition
		newPatient.getMuscleCondition().Update(Conditions.ConditionStatus.Normal); // Update condition
		newPatient.getNoseCondition().Update(Conditions.ConditionStatus.Critic); // Update condition
		newDevice.receive(newPatient); // Send updated patient data to phone.
		Database.getDB().addDevice(newDevice); // Add new device to database.
		
		newDevice = new DeviceAdapter(new Samsung()); // New User installed app.
		newPatient = new Patient("Furkan Özyürek","13.04.1987","Ata Cad. Balçova Ýzmir"); // Created new patient
		newPatient.setDevice(newDevice); // Assign device as patient's device at database
		newPatient.getFeverCondition().Update(Conditions.ConditionStatus.Normal); // Update condition
		newPatient.getMuscleCondition().Update(Conditions.ConditionStatus.Critic); // Update condition
		newPatient.getNoseCondition().Update(Conditions.ConditionStatus.Critic); // Update condition
		newDevice.receive(newPatient); // Send updated patient data to phone.
		Database.getDB().addDevice(newDevice); // Add new device to database.
		
		newDevice = new DeviceAdapter(new iPhone()); // New User installed app.
		newPatient = new Patient("Sabri Sarýoðlu","26.07.1984","Ata Cad. Balçova Ýzmir"); // Created new patient
		newPatient.setDevice(newDevice); // Assign device as patient's device at database
		newPatient.getFeverCondition().Update(Conditions.ConditionStatus.Normal); // Update condition
		newPatient.getMuscleCondition().Update(Conditions.ConditionStatus.Critic); // Update condition
		newPatient.getNoseCondition().Update(Conditions.ConditionStatus.Critic); // Update condition
		newDevice.receive(newPatient); // Send updated patient data to phone.
		Database.getDB().addDevice(newDevice); // Add new device to database.
		
		System.out.println("New patients and devices created at database."); 
	}
	
	static class TimerForUpdate extends TimerTask // Time for check last update time.
	{
	    public void run() 
	    {
	       for(Patient p : Database.getDB().getPatients())
	       {
	    	   if(Functions.hoursDiff(p.getLastConditionsUpdate(),Calendar.getInstance().getTime())>= 2 || true) // Remove 'true' will make it work properly. It is just for testing.
	    	   {
	    		   p.getDevice().receive("You have to update your conditions. (2 hours passed)");
	    	   }
	       }
	    }
	}

	
	public static void main(String[] args) 
	{
		AddDevices(); //For testing purpose
		
		QueryOne(); 	// Shows Patients between ages 25-60
		QueryTwo(); 	// Shows Patients whose fever condition is criting.
		QueryThree(); 	// Shows patients between ages 25-60 & got muscle ache is critic and prints last condition update time.
		QueryFour(); 	// This one has extra profile card
		
		StartUpdateTimeCheck(); // Checks last-condition update time every minute.
	}
	
	
	static void StartUpdateTimeCheck()
	{
		long seconds_to_run = 60 * 1000;
		Timer timer = new Timer();
		timer.schedule(new TimerForUpdate(), seconds_to_run, seconds_to_run); // Check every minute for last-update difference in hours.
	}
	
	public static void QueryOne()
	{
		System.out.println("Searching for patients between ages 25-60 and printing count");
		System.out.println("______________________________________________");
		PatientList<Patient> SearchResult = Database.getDB().getPatients().SearchByAge(">", 25).SearchByAge("<", 60);
		for(Patient p : SearchResult)
		{
			System.out.println(p.getName());
			System.out.println("");
		}
		System.out.println("Found " + SearchResult.size() + " results.");
		System.out.println("\n\n\n\n");
	}
	
	public static void QueryTwo()
	{
		System.out.println("Searching for patients fever critic and printing condition information");
		System.out.println("______________________________________________");
		PatientList<Patient> SearchResult = Database.getDB().getPatients().SearchByCondition(Conditions.ConditionType.Fever, Conditions.ConditionStatus.Critic);
		for(Patient p : SearchResult)
		{
			System.out.println(p.getName());
			p.printConditionInfos();
			System.out.println("");
		}
		System.out.println("Found " + SearchResult.size() + " results.");
		System.out.println("\n\n\n\n");
	}
	
	public static void QueryThree()
	{
		System.out.println("Searching for patients between ages 25-60, got muscle ache is critic and printing last update date");
		System.out.println("______________________________________________");
		PatientList<Patient> SearchResult = Database.getDB().getPatients().SearchByAge(">", 25).SearchByAge("<", 60).SearchByCondition(Conditions.ConditionType.MuscleAche, Conditions.ConditionStatus.Critic);
		for(Patient p : SearchResult)
		{
			System.out.println(p.getName());
			System.out.println(p.getMuscleCondition().getName() + " - " + p.getMuscleCondition().getStatus());
			System.out.println("Last Condition Update: " + p.getLastConditionsUpdate());
			System.out.println("");
		}
		System.out.println("Found " + SearchResult.size() + " results.");
		System.out.println("\n\n\n\n");
	}
	
	
	// Extra one
	public static void QueryFour()
	{
		System.out.println("Searching for patients in Balçova between ages 15-60 with runny-nose condition status is critic");
		System.out.println("______________________________________________");
		PatientList<Patient> SearchResult = Database.getDB().getPatients().SearchByAddress("Balçova").SearchByAge(">", 15).SearchByAge("<", 60);
		for(Patient p : SearchResult)
		{
			p.getInfo();
		}
		System.out.println("Found " + SearchResult.size() + " results.");
		System.out.println("\n\n\n\n");
	}
}
