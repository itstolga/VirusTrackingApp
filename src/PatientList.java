import java.util.ArrayList;

public class PatientList<E> extends ArrayList<Patient> {

	private static final long serialVersionUID = 1L;

	public PatientList<Patient> SearchByName(String name)
	{
		PatientList<Patient> founded = new PatientList<Patient>();

		for(Patient p : this)
		{
			if(p.getName().equals(name))
			{
				founded.add(p);
			}
		}
		return founded;
	}
	
	public PatientList<Patient> SearchByCondition(String condition, String status)
	{
		PatientList<Patient> founded = new PatientList<Patient>();

		for(Patient p : this)
		{
			for(Condition c : p.getConditions().getInfo())
			{
				if(c.name.equals(condition) && c.status.equals(status))
				{
					founded.add(p);
				}
			}
		}
		return founded;
	}
	
	public PatientList<Patient> SearchByAddress(String add)
	{
		PatientList<Patient> founded = new PatientList<Patient>();

		for(Patient p : this)
		{
			if(p.getAddress().contains(add))
			{
				founded.add(p);
			}
		}
		return founded;
	}
	
}