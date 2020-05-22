// Composite Pattern

import java.util.Calendar;
import java.util.Date;


public class Conditions 
{
	public enum ConditionStatus {
		Normal, Critic, Unknown
	}
	
	public enum ConditionType {
		Fever,MuscleAche,RunnyNose
	}

	
	interface Condition {
		public void Update(ConditionStatus conditionStatus);

		public String getName();
		public ConditionStatus getStatus();
		public ConditionType getType();
		public Date getLastUpdateDate();
		public Location getLastUpdateLocation();
	}

	
	
	public class Fever implements Condition {
		private ConditionType conditionType;
		private String name;
		@SuppressWarnings("unused")
		private ConditionStatus conditionStatus;
		@SuppressWarnings("unused")
		private Date lastUpdateDate;
		@SuppressWarnings("unused")
		private Location lastLocation;

		public Fever() {
			this.conditionType = ConditionType.Fever;
			this.name = "Fever";
			this.conditionStatus = ConditionStatus.Unknown;
		}

		@Override
		public void Update(ConditionStatus conditionStatus) {
			this.conditionStatus = conditionStatus;
			this.lastLocation = new Location("38.3726", "27.0387"); // Balçova / Ýzmir coordinates for testing
			this.lastUpdateDate = Calendar.getInstance().getTime();
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public ConditionStatus getStatus() {
			return this.conditionStatus;
		}

		@Override
		public ConditionType getType() {
			return this.conditionType;
		}

		@Override
		public Date getLastUpdateDate() {
			return lastUpdateDate;
		}

		@Override
		public Location getLastUpdateLocation() {
			return lastLocation;
		}
	}
	
	public class MuscleAche implements Condition {
		private ConditionType conditionType;
		private String name;
		@SuppressWarnings("unused")
		private ConditionStatus conditionStatus;
		@SuppressWarnings("unused")
		private Date lastUpdateDate;
		@SuppressWarnings("unused")
		private Location lastLocation;

		public MuscleAche() {
			this.conditionType = ConditionType.MuscleAche;
			this.name = "Muscle Ache";
			this.conditionStatus = ConditionStatus.Unknown;
		}

		@Override
		public void Update(ConditionStatus conditionStatus) {
			this.conditionStatus = conditionStatus;
			this.lastLocation = new Location("38.3726", "27.0387"); // Balçova / Ýzmir coordinates for testing
			this.lastUpdateDate = Calendar.getInstance().getTime();
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public ConditionStatus getStatus() {
			return this.conditionStatus;
		}

		@Override
		public ConditionType getType() {
			return this.conditionType;
		}
		

		@Override
		public Date getLastUpdateDate() {
			return lastUpdateDate;
		}

		@Override
		public Location getLastUpdateLocation() {
			return lastLocation;
		}
	}
	
	public class RunnyNose implements Condition {
		private ConditionType conditionType;
		private String name;
		@SuppressWarnings("unused")
		private ConditionStatus conditionStatus;
		@SuppressWarnings("unused")
		private Date lastUpdateDate;
		@SuppressWarnings("unused")
		private Location lastLocation;

		public RunnyNose() {
			this.conditionType = ConditionType.RunnyNose;
			this.name = "Runny Nose";
			this.conditionStatus = ConditionStatus.Unknown;
		}

		@Override
		public void Update(ConditionStatus conditionStatus) {
			this.conditionStatus = conditionStatus;
			this.lastLocation = new Location("38.3726", "27.0387"); // Balçova / Ýzmir coordinates for testing
			this.lastUpdateDate = Calendar.getInstance().getTime();
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public ConditionStatus getStatus() {
			return this.conditionStatus;
		}

		@Override
		public ConditionType getType() {
			return this.conditionType;
		}
		

		@Override
		public Date getLastUpdateDate() {
			return lastUpdateDate;
		}

		@Override
		public Location getLastUpdateLocation() {
			return lastLocation;
		}
		
	}
}
