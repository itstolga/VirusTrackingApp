// Device class implemented from Library

public class Device implements Library
{
	
	public enum DataType
	{
		PatientProfile
	}
	
	
	Patient owner;

	@Override
	public Object send(DataType dataType)
	{
		if(dataType == DataType.PatientProfile)
		{
			return this.owner;
		}
		return null;
	}

	@Override
	public void receive(Object p) 
	{
		if(p instanceof Patient)
		{
			this.owner = (Patient) p;
		}
		else if(p instanceof String) // Get message from database
		{
			System.out.println("[SENT TO "+this.owner.getName()+"] "+p); //Shows to server
			getMessage("You have updated your profile"); // Shows to device user
		}
	}
	
	@Override
	public void getMessage(String message)
	{
		// Message sent to device
	}
	
	/*public void Register(String name, String birthDate, String address)
	{
		if(owner == null)
		{
			owner = new Patient(name, birthDate, address);
		}
	}
	
	
	public void UpdateCondition(Conditions.ConditionType conditionType, Conditions.ConditionStatus conditionStatus)
	{
		for(Conditions.Condition c : owner.getConditions())
		{
			if(c.getType().equals(conditionType))
			{
				c.Update(conditionStatus);
				break;
			}
		}
	}*/
}