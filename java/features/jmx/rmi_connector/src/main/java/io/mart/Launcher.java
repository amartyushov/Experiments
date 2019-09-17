package io.mart;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;

public class Launcher {
	
	
	public static void main(String[] args)
			throws MalformedObjectNameException, MBeanRegistrationException, InstanceAlreadyExistsException,
			NotCompliantMBeanException, IOException {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		System.out.println(server.getMBeanCount());
		
		for (Object object : server.queryMBeans(new ObjectName("*:*"), null)) {
			System.out.println(((ObjectInstance) object).getObjectName());
		}
		
		registerMyMBean(server);
		System.out.println("Press any key to exit");
		System.in.read();
	}
	
	
	private static void registerMyMBean(MBeanServer server)
			throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException,
			MBeanRegistrationException {
		Game game = new Game();
		ObjectName mbeanName = new ObjectName("io.mart:type=GameBean");
		
		server.registerMBean(game, mbeanName);
	}
}
