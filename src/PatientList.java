import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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
	
	public PatientList<Patient> SearchByCondition(Conditions.ConditionType conditionType, Conditions.ConditionStatus status)
	{
		PatientList<Patient> founded = new PatientList<Patient>();

		for(Patient p : this)
		{
			for(Conditions.Condition c : p.getConditions())
			{
				if(c.getType().equals(conditionType) && c.getStatus().equals(status))
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
	
	public PatientList<Patient> SearchByAge(String condition, int age)
	{
		PatientList<Patient> founded = new PatientList<Patient>();
		
		ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        
		for(Patient p : this)
		{
			try {
				engine.eval("value = "+p.getAge());
		        Boolean isOkay = (Boolean) engine.eval("value "+condition+" "+age);
				if(isOkay)
				{
					founded.add(p);
				}
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return founded;
	}
}