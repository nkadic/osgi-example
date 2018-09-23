/*
 * Apache Felix OSGi tutorial.
 **/

package tutorial.example1;

import org.osgi.framework.*;

/**
 * This class implements a simple bundle that utilizes the OSGi
 * framework's event mechanism to listen for service events. Upon
 * receiving a service event, it prints out the event's details.
 **/
public class Activator implements BundleActivator, ServiceListener, BundleListener
{
    /**
     * Implements BundleActivator.start(). Prints
     * a message and adds itself to the bundle context as a service
     * listener.
     * @param context the framework context for the bundle.
     **/
    public void start(BundleContext context)
    {
        System.out.println("Starting to listen for service events.");
        context.addServiceListener(this);
        System.out.println("Starting to listen for bundle events.");
        context.addBundleListener(this);

    }

    /**
     * Implements BundleActivator.stop(). Prints
     * a message and removes itself from the bundle context as a
     * service listener.
     * @param context the framework context for the bundle.
     **/
    public void stop(BundleContext context)
    {
        context.removeServiceListener(this);
        System.out.println("Stopped listening for service events.");
        context.removeBundleListener(this);
        System.out.println("Stopped listening for bundle events.");

        // Note: It is not required that we remove the listener here,
        // since the framework will do it automatically anyway.
    }

    /**
     * Implements ServiceListener.serviceChanged().
     * Prints the details of any service event from the framework.
     * @param event the fired service event.
     **/
    public void serviceChanged(ServiceEvent event)
    {
        String[] objectClass = (String[])
                event.getServiceReference().getProperty("objectClass");

        if (event.getType() == ServiceEvent.REGISTERED)
        {
            System.out.println(
                    "Ex1: Service of type " + objectClass[0] + " registered.");
        }
        else if (event.getType() == ServiceEvent.UNREGISTERING)
        {
            System.out.println(
                    "Ex1: Service of type " + objectClass[0] + " unregistered.");
        }
        else if (event.getType() == ServiceEvent.MODIFIED)
        {
            System.out.println(
                    "Ex1: Service of type " + objectClass[0] + " modified.");
        }
    }

    public void bundleChanged(BundleEvent event) {

        String bundleLocation = event.getBundle().getLocation();
        if (event.getType() == BundleEvent.INSTALLED)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " INSTALLED.");
        }
        if (event.getType() == BundleEvent.STARTED)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " STARTED.");
        }
        if (event.getType() == BundleEvent.RESOLVED)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " RESOLVED.");
        }
        if (event.getType() == BundleEvent.STARTING)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " STARTING.");
        }

        if (event.getType() == BundleEvent.STOPPED)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " STOPPED.");
        }
        if (event.getType() == BundleEvent.STOPPING)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " STOPPING.");
        }
        if (event.getType() == BundleEvent.UNINSTALLED)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " UNINSTALLED.");
        }
        if (event.getType() == BundleEvent.UNRESOLVED)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " UNRESOLVED.");
        }
        if (event.getType() == BundleEvent.UPDATED)
        {
            System.out.println("Ex1: Bundle with location  " + bundleLocation + " UPDATED.");
        }
    }
}