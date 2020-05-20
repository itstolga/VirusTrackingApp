import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ConditionInfo {
	
	private ArrayList<Condition> Conditions = new ArrayList<Condition>();
	private Location lastLocation;
	private Date lastUpdate;
	
	public ArrayList<Condition> getInfo()
	{
		return Conditions;
	}
	
	public void Update()
	{
		lastUpdate = Calendar.getInstance().getTime();
		lastLocation = getLocation();
		System.out.println(lastUpdate + " " + lastLocation.getString());
	}
	
	
	Location getLocation()
	{
		return new Location("38.3726", "27.0387"); // For example it is the coordinates of Balçova / Ýzmir.
	}
}