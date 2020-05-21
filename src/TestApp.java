
public class TestApp 
{
	static void AddPatients(Database database)
	{
		Patient test = new Patient("Tolga Yavuz");
		test.setPassword("123");
		test.setDevice(new Samsung());
		test.getFeverCondition().Update(Conditions.ConditionStatus.Normal);
		test.getMuscleCondition().Update(Conditions.ConditionStatus.Critic);
		test.getNoseCondition().Update(Conditions.ConditionStatus.Critic);
		test.setBirthDate(Functions.giveDate("26.11.1995"));
		test.setAddress("Sakarya Cad. Balçova / Ýzmir");
		database.addPatient(test);
		
		
		Patient test2 = new Patient("Eren Önem");
		test2.setPassword("456");
		test2.setDevice(new Samsung());
		test2.getFeverCondition().Update(Conditions.ConditionStatus.Critic);
		test2.getMuscleCondition().Update(Conditions.ConditionStatus.Normal);
		test2.getNoseCondition().Update(Conditions.ConditionStatus.Critic);
		test2.setBirthDate(Functions.giveDate("18.02.1997"));
		test2.setAddress("Ata Cad. Balçova / Ýzmir");
		database.addPatient(test2);
		
		Patient test3 = new Patient("Burak Saraç");
		test3.setPassword("978");
		test3.setDevice(new Samsung());
		test3.getFeverCondition().Update(Conditions.ConditionStatus.Critic);
		test3.getMuscleCondition().Update(Conditions.ConditionStatus.Normal);
		test3.getNoseCondition().Update(Conditions.ConditionStatus.Critic);
		test3.setBirthDate(Functions.giveDate("11.09.1996"));
		test3.setAddress("Sipahiler Sk. Balçova / Ýzmir");
		database.addPatient(test3);
	}
	
	public static void main(String[] args) 
	{
		AddPatients(Database.getDB());
		QueryOne();
		QueryTwo();
		QueryThree();
		//QueryFour(); // This one extra
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
		System.out.println("Searching for patients in Balçova between ages 15-30 with runny-nose condition status is critic");
		System.out.println("______________________________________________");
		PatientList<Patient> SearchResult = Database.getDB().getPatients().SearchByAddress("Balçova").SearchByAge(">", 15).SearchByAge("<", 30).SearchByCondition(Conditions.ConditionType.RunnyNose, Conditions.ConditionStatus.Critic);
		for(Patient p : SearchResult)
		{
			p.getInfo();
		}
		System.out.println("Found " + SearchResult.size() + " results.");
		System.out.println("\n\n\n\n");
	}
}
