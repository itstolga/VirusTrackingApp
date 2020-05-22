// Location object to hold coordinates.

public class Location 
{
	String x_pos;
	String y_pos;
	
	Location(String x, String y)
	{
		this.x_pos = x;
		this.y_pos = y;
	}
	
	public String getString()
	{
		return "("+x_pos+","+y_pos+")";
	}
}
