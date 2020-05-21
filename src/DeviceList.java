import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DeviceList<E> extends ArrayList<Device> {

	private static final long serialVersionUID = 1L;

	public DeviceList<Device> SearchByName(String name)
	{
		DeviceList<Device> founded = new DeviceList<Device>();

		for(Device d : this)
		{
			Patient p = (Patient) d.send(Device.DataType.PatientProfile);
			if(p.getName().equals(name))
			{
				founded.add(d);
			}
		}
		return founded;
	}
	
	public DeviceList<Device> SearchByCondition(Conditions.ConditionType conditionType, Conditions.ConditionStatus status)
	{
		DeviceList<Device> founded = new DeviceList<Device>();

		for(Device d : this)
		{
			Patient p = (Patient) d.send(Device.DataType.PatientProfile);
			for(Conditions.Condition c : p.getConditions())
			{
				if(c.getType().equals(conditionType) && c.getStatus().equals(status))
				{
					founded.add(d);
				}
			}
		}
		return founded;
	}
	
	public DeviceList<Device> SearchByAddress(String add)
	{
		DeviceList<Device> founded = new DeviceList<Device>();

		for(Device d : this)
		{
			Patient p = (Patient) d.send(Device.DataType.PatientProfile);
			if(p.getAddress().contains(add))
			{
				founded.add(d);
			}
		}
		return founded;
	}
	
	public DeviceList<Device> SearchByAge(String condition, int age)
	{
		DeviceList<Device> founded = new DeviceList<Device>();
		
		ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        
		for(Device d : this)
		{
			Patient p = (Patient) d.send(Device.DataType.PatientProfile);
			try {
				engine.eval("value = "+p.getAge());
		        Boolean isOkay = (Boolean) engine.eval("value "+condition+" "+age);
				if(isOkay)
				{
					founded.add(d);
				}
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return founded;
	}
}