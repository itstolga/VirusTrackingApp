import java.util.ArrayList;

public class Database 
{
	public static Database instance;
	private Database() { }
	
	private static PatientList<Patient> Patients = new PatientList<Patient>();
	private static DeviceList<Device> Devices = new DeviceList<Device>();
	
	public static Database getDB()
	{
		if(instance == null) return new Database();
		else return instance;
	}
	
	
	public void addPatient(Patient p) { Patients.add(p); }
	public PatientList<Patient> getPatients() { return Patients; }
	public void removePatient(Patient p) { Patients.remove(p); }
	
	
	public DeviceList<Device> getDevices() { return Devices; }
	
	public void addDevice(Device d) { 
		Devices.add(d); 
		Patients.add( (Patient) d.send(Device.DataType.PatientProfile)); 
	}
	
	public void removeDevice(Device d) { Devices.remove(d); }
}