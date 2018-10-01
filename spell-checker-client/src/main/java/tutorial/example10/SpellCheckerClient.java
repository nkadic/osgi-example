package tutorial.example10;



//import aQute.bnd.annotation.component.Activate;
//import aQute.bnd.annotation.component.Component;
//import aQute.bnd.annotation.component.Deactivate;
//import aQute.bnd.annotation.component.Reference;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.References;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import tutorial.example6.service.SpellChecker;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This annotation declares the class as an SCR component and specifies
 * that it should be immediately activated once its dependencies have been
 * satisfied. In this instance, the component will be activated after the
 * GreetingService has been injected.
 *
 */
@Component(immediate = true)
@References({
        @Reference(
                name = SpellCheckerClient.SERVICE_NAME,
                referenceInterface = SpellChecker.class,
                policy = ReferencePolicy.DYNAMIC,
                cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE)
})
public class SpellCheckerClient {
    public static final String SERVICE_NAME = "spellChecker";

    private Map<String, SpellChecker> spellChecker = new ConcurrentHashMap<String, SpellChecker>();

    public SpellCheckerClient() {
        System.out.println("GreetingServiceClient instantiated");
    }
    @Activate
    private void activate() {
        System.out.println("Ex1: activate");
        String[] result = spellChecker.get(SpellChecker.class.getClass().getCanonicalName()).check("Greeting Service Client and Welcome to the OSGI Tutorial");
        System.out.println("RESULTS:");
        System.out.println(Arrays.toString(result));

    }


    public void bindSpellChecker(final SpellChecker service,
                                 final Map<Object, Object> props) {

        this.spellChecker.put(service.getClass().getCanonicalName(), service);
    }


    public void unbindSpellChecker(final SpellChecker service,
                                   final Map<Object, Object> props) {
        this.spellChecker.remove(service.getClass().getCanonicalName());

    }

    @Deactivate
    public void deactivate() {
        System.out.println("SpellCheckerClient deactivated");

    }
}
