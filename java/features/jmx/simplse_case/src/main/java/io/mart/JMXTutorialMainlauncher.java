package io.mart;

import java.lang.management.ManagementFactory;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class JMXTutorialMainlauncher {
	
	public static void main(String[] args) {
		
		ObjectName objectName = null;
		try {
			objectName = new ObjectName("io.mart:type=basic,name=game");
		} catch (MalformedObjectNameException e) {
			throw new RuntimeException(e);
		}
		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		Game gameObj = new Game();
		try {
			server.registerMBean(gameObj, objectName);
		} catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
			throw new RuntimeException(e);
		}
		
		
		while (true) {
			// to ensure application does not terminate
		}
	}
	
}
