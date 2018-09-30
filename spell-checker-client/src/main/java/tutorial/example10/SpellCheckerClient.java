package tutorial.example10;



import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import aQute.bnd.annotation.component.Reference;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import tutorial.example6.service.SpellChecker;

import java.util.Arrays;

/*
 * This annotation declares the class as an SCR component and specifies
 * that it should be immediately activated once its dependencies have been
 * satisfied. In this instance, the component will be activated after the
 * GreetingService has been injected.
 *
 */
@Component(immediate = true)
public class SpellCheckerClient {

    private volatile SpellChecker spellChecker;

    public SpellCheckerClient() {
        System.out.println("GreetingServiceClient instantiated");
    }
    @Activate
    private void activate() {
        System.out.println("Ex1: activate");
        String[] result = spellChecker.check("Greeting Service Client and Welcome to the OSGI Tutorial");
        System.out.println("RESULTS:");
        System.out.println(Arrays.toString(result));

    }

    /**
     * This annotation is the declaration to SCR that this is the location to
     * inject the GreetingService implementation. We have also included a
     * non-default
     * unbind method reference to indicate the "removeGreetingService" should be
     * called
     * if the GreetingService is no longer available. The default would have
     * been to call
     * a method by the same name as our injection method name prefixed by "un".
     * In
     * this case that would have been "unsetGreetingService".
     */

    @Reference(service = SpellChecker.class, unbind = "unsetSpellChecker")
    public void setSpellChecker(SpellChecker spellChecker) {

        this.spellChecker = spellChecker;
    }

    /**
     * This method demonstrates the unbind life-cycle hook.
     */
    public void unsetSpellChecker(SpellChecker greetingService) {
    }

    @Deactivate
    public void deactivate() {
        System.out.println("GreetingServiceClient deactivated");
    }
}
