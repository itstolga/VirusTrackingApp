
public class TestApp 
{
	static Database ConnectDatabase()
	{
		return Database.getDB();
	}
	
	static void AddPatients(Database database)
	{
		Patient test = new Patient("Tolga");
		test.setPassword("123");
		test.setDevice(new Samsung());
		test.addCondition(new Condition("Kalp",Condition.ConditionStatus.Critic));
		test.addCondition(new Condition("Akciðer",Condition.ConditionStatus.Normal));
		test.addCondition(new Condition("Koku Alma",Condition.ConditionStatus.Critic));
		test.setBirthDate(Functions.giveDate("26.11.1995"));
		test.setAddress("Sakarya Cad. Balçova / Ýzmir");
		database.addPatient(test);
		
		
		Patient test2 = new Patient("Eren");
		test2.setPassword("456");
		test2.setDevice(new Samsung());
		test2.addCondition(new Condition("Kalp",Condition.ConditionStatus.Normal));
		test2.addCondition(new Condition("Akciðer",Condition.ConditionStatus.Normal));
		test2.addCondition(new Condition("Koku Alma",Condition.ConditionStatus.Critic));
		test2.setBirthDate(Functions.giveDate("26.11.2010"));
		test2.setAddress("Sakarya Cad. Balçova / Ýzmir");
		database.addPatient(test2);
	}
	
	public static void main(String[] args) 
	{
		Database database = ConnectDatabase();
		AddPatients(database);
		
		System.out.println("Searching");
		for(Patient p : database.getPatients().SearchByName("Eren").SearchByCondition("Kalp", "Normal").SearchByAge(">", 9))
		{
			p.getInfo();
		}
		
		/*System.out.println("Searching");
		for(Patient p : sE.SearchPatient("name=Tolga,password=123,condition=Kalp-Normal"))
				p.getInfo();*/
	
	}
}
