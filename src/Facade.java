import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class Facade {
	
	 void start() {
			AddDevices(); //For testing purpose
			StartUpdateTimeCheck(); // Checks last-condition update time every minute.
			
			SearchEngine searchEngine = new SearchEngine(Database.getDB().getPatients());
			
			searchEngine.Execute(1);	// Shows Patients between ages 25-60
			searchEngine.Execute(2);	// Shows Patients whose fever condition is criting.
			searchEngine.Execute(3);	// Shows patients between ages 25-60 & got muscle ache is critic and prints last condition update time.
			searchEngine.Execute(4); 	// This one has extra profile card*/	
	 }
	 
	 void AddDevices()
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
	
	 class TimerForUpdate extends TimerTask // Time for check last update time.
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
	 void StartUpdateTimeCheck()
	{
		long seconds_to_run = 60 * 1000;
		Timer timer = new Timer();
		timer.schedule(new TimerForUpdate(), seconds_to_run, seconds_to_run); // Check every minute for last-update difference in hours.
	}
	
}
