public class Condition {
	String name;
	String status;
	
	enum ConditionStatus
	{
		Normal,
		Critic
	}
	
	public Condition(String name, ConditionStatus conditionStatus)
	{
		this.name = name;
		this.status = conditionStatus.toString();
	}
}
