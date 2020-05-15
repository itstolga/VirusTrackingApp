import java.util.ArrayList;

public class SearchEngineOLD
{
	Database db;
	
	public SearchEngineOLD()
	{
		ConnectDB();
	}

	public void ConnectDB()
	{
		db = Database.getDB();
	}

	public ArrayList<Patient> SearchPatient(String query)
	{
		ArrayList<Patient> founded = new ArrayList<Patient>();
		
		String[] parameters = query.split(",");
		
		
		for(Patient p : db.getPatients())
		{
			boolean Found = false;
			for(String param : parameters)
			{
				String attribute = param.split("=")[0];
				String value = param.split("=")[1];

				
				if(attribute.equals("password"))
				{
					Found = false;
					if(p.getPassword().equals(value))
						Found = true;
				}
				
				
				if(attribute.equals("name"))
				{
					Found = false;
					if(p.getName().equals(value))
						Found = true;
				}
				
				
				if(attribute.contains("condition"))
				{
					String conditionName = value.split("-")[0];
					String conditionStatus = value.split("-")[1];
					
					for(Condition condition : p.getConditions().getInfo())
					{
						if(condition.name.equals(conditionName))
						{
							Found = false;
							if(condition.status.equals(conditionStatus))
								Found = true;
						}
					}
				}
				
			}
			
			if(Found) founded.add(p);
		}
		
		return founded;
	}
}
