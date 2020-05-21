public class DeviceAdapter implements Library 
{
    private Device operatingSystem;

    public DeviceAdapter(Device os) {
        this.operatingSystem = os;
    }
    public Device getDevice() {
    	return operatingSystem;
    }

    @Override
    public void receive() {
        if (operatingSystem instanceof Samsung) {
            ((Samsung) operatingSystem).get();
        } else if (operatingSystem instanceof iPhone) {
             ((iPhone) operatingSystem).read();
        }
    }

    @Override
    public Object send() {
        if (operatingSystem instanceof Samsung) {
            return ((Samsung) operatingSystem).set();
        } else if (operatingSystem instanceof iPhone) {
            return ((iPhone) operatingSystem).write();
        }
        return null;
    }
}
