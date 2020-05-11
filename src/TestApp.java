
public class TestApp {

	public static void main(String[] args) 
	{
		Patient test = new Patient("Tolga");
		test.setDevice(new Samsung());
		test.addCondition(new Condition("Kalp","bitik"));
		test.addCondition(new Condition("Akciðer","bitik"));
		test.addCondition(new Condition("Koku Alma","idare eder"));
		test.setBirthDate(Functions.giveDate("26.11.1995"));
		test.setAddress("Sakarya Cad. Balçova / Ýzmir");
		test.getInfo();
		
		Patient test2 = new Patient("Tolga2");
		test2.setDevice(new Samsung());
		test2.addCondition(new Condition("Kalp","bitik"));
		test2.addCondition(new Condition("Akciðer","bitik"));
		test2.addCondition(new Condition("Koku Alma","idare eder"));
		test2.setBirthDate(Functions.giveDate("26.11.2010"));
		test2.getInfo();
	}
}
