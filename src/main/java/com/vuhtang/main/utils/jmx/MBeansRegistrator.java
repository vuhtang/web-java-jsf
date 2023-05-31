package com.vuhtang.main.utils.jmx;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import javax.management.*;
import java.lang.management.ManagementFactory;

@Named("mBeansRegistrator")
@ApplicationScoped
public class MBeansRegistrator {

    private static final MBeanServer server = ManagementFactory.getPlatformMBeanServer();

    public static void registerBean(String objectName, Object bean) {
        try {
            ObjectName name = new ObjectName(objectName);
            server.registerMBean(bean, name);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException |
                 MBeanRegistrationException | NotCompliantMBeanException e) {
            System.out.println(e.getMessage());
        }
    }

}
