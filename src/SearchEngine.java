// Command Pattern

interface Command
{
	public void Execute(int type);
}


public class SearchEngine implements Command 
{
	private Engine engine;
	@SuppressWarnings("unused")
	private PatientList<Patient> list;
	
	public SearchEngine(PatientList<Patient> list)
	{
		this.list = list;
		this.engine = new Engine(list);
	}
	
	public void Execute(int type) 
	{
		engine.Search(type);
	}
}


class Engine 
{
	private PatientList<Patient> list;
	
	public Engine(PatientList<Patient> list)
	{
		this.list = list;
	}
	
	public void Search(int type)
	{
		PatientList<Patient> SearchResult = null;
		switch(type)
		{
			case 1:
				System.out.println("Searching for patients between ages 25-60 and printing count");
				System.out.println("______________________________________________");
				SearchResult = list.SearchByAge(">", 25).SearchByAge("<", 60);
				for(Patient p : SearchResult)
				{
					System.out.println(p.getName());
					System.out.println("");
				}
				System.out.println("Found " + SearchResult.size() + " results.");
				System.out.println("\n\n\n\n");
				break;
			case 2:
				System.out.println("Searching for patients fever critic and printing condition information");
				System.out.println("______________________________________________");
				SearchResult = list.SearchByCondition(Conditions.ConditionType.Fever, Conditions.ConditionStatus.Critic);
				for(Patient p : SearchResult)
				{
					System.out.println(p.getName());
					p.printConditionInfos();
					System.out.println("");
				}
				System.out.println("Found " + SearchResult.size() + " results.");
				System.out.println("\n\n\n\n");
				break;
			case 3:
				System.out.println("Searching for patients between ages 25-60, got muscle ache is critic and printing last update date");
				System.out.println("______________________________________________");
				SearchResult = list.SearchByAge(">", 25).SearchByAge("<", 60).SearchByCondition(Conditions.ConditionType.MuscleAche, Conditions.ConditionStatus.Critic);
				for(Patient p : SearchResult)
				{
					System.out.println(p.getName());
					System.out.println(p.getMuscleCondition().getName() + " - " + p.getMuscleCondition().getStatus());
					System.out.println("Last Condition Update: " + p.getLastConditionsUpdate());
					System.out.println("");
				}
				System.out.println("Found " + SearchResult.size() + " results.");
				System.out.println("\n\n\n\n");
				break;
			case 4:
				System.out.println("Searching for patients in Balçova between ages 15-60 with runny-nose condition status is critic");
				System.out.println("______________________________________________");
				SearchResult = list.SearchByAddress("Balçova").SearchByAge(">", 15).SearchByAge("<", 60);
				for(Patient p : SearchResult)
				{
					p.getInfo();
				}
				System.out.println("Found " + SearchResult.size() + " results.");
				System.out.println("\n\n\n\n");
				break;
		}
	}
	
}