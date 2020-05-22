// Adapter Pattern

// Also observer pattern at getMessage method.

public class DeviceAdapter extends Device 
{
    private Device operatingSystem;

    public DeviceAdapter(Device os) {
        this.operatingSystem = os;
    }
    public Device getDevice() {
    	return operatingSystem;
    }

    @Override
    public Object send(Device.DataType dataType) {
        if (operatingSystem instanceof Samsung) {
            return ((Samsung) operatingSystem).get(dataType);
        } else if (operatingSystem instanceof iPhone) {
        	return ((iPhone) operatingSystem).read(dataType);
        }
        return null;
    }

    @Override
    public void receive(Object p) {
        if (operatingSystem instanceof Samsung) {
            ((Samsung) operatingSystem).set(p);
        } else if (operatingSystem instanceof iPhone) {
            ((iPhone) operatingSystem).write(p);
        }
    }
    
    @Override
    public void getMessage(String message)
    {
        if (operatingSystem instanceof Samsung) {
            ((Samsung) operatingSystem).SendNotification(message);
        } else if (operatingSystem instanceof iPhone) {
            ((iPhone) operatingSystem).ShowMessage(message);
        }
    }
}
