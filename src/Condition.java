public class Condition {
	String name;
	ConditionStatus status;
	
	public enum ConditionStatus
	{
		Normal,
		Critic,
		Unknown
	}
	
	public Condition(String name, ConditionStatus conditionStatus)
	{
		this.name = name;
		this.status = conditionStatus;
	}
}
