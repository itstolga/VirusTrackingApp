import java.util.ArrayList;
import java.util.Date;

public class ConditionInfo {
	
	public ArrayList<Condition> Conditions = new ArrayList<>();
	private Location lastLocation;
	private Date lastUpdate;
	
	ConditionInfo(ArrayList<Condition> Conditions, Location lastLocation, Date lastUpdate)
	{
		this.Conditions = Conditions;
		this.lastLocation = lastLocation;
	}
}