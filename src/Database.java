import java.util.ArrayList;

public class Database 
{
	public static Database instance;
	private Database() { }
	
	
	
	private ArrayList<Patient> Patients;
	
	public static Database getDB()
	{
		if(instance == null) return new Database();
		else return instance;
	}
	
	
	
	public void addPatient(Patient p) { Patients.add(p); }
	public ArrayList<Patient> getPatients() { return Patients; }
}