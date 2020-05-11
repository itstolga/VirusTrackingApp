import java.util.ArrayList;
import java.util.Date;

public class ConditionInfo {
	
	private ArrayList<Condition> Conditions = new ArrayList<Condition>();
	private Location lastLocation;
	private Date lastUpdate;
	
	public ArrayList<Condition> getInfo()
	{
		return Conditions;
	}
}