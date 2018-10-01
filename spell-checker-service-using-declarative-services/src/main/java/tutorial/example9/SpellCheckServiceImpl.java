/*
 * Apache Felix OSGi tutorial.
 **/

package tutorial.example9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;


//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.References;


import tutorial.example2.service.DictionaryService;
import tutorial.example6.service.SpellChecker;

//import aQute.bnd.annotation.component.Activate;
//import aQute.bnd.annotation.component.Deactivate;
//import aQute.bnd.annotation.component.Reference;
/**
 * This class re-implements the spell check service of Example 6. This service
 * implementation behaves exactly like the one in Example 6, specifically, it
 * aggregates all available dictionary services, monitors their dynamic
 * availability, and only offers the spell check service if there are dictionary
 * services available. The service implementation is greatly simplified, though,
 * by using the Service Component Runtime. Notice that there is no OSGi references in the
 * application code; instead, the annotations describe the service
 * dependencies to the Service Component Runtime, which automatically manages them and it
 * also automatically registers the spell check services as appropriate.
 */
@Component(immediate = true)
@References({
        @Reference(
                name = SpellCheckServiceImpl.SERVICE_NAME,
                referenceInterface = DictionaryService.class,
                policy = ReferencePolicy.DYNAMIC,
                cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE)
})
@Service
public class SpellCheckServiceImpl implements SpellChecker
{
    public static final String SERVICE_NAME = "dictionaryService";

    private Map<String, DictionaryService> dictionaryService = new ConcurrentHashMap<String, DictionaryService>();



    public void bindDictionaryService(final DictionaryService service,
                                 final Map<Object, Object> props) {

        this.dictionaryService.put(service.getClass().getCanonicalName(), service);
    }


    public void unbindDictionaryService(final DictionaryService service,
                                   final Map<Object, Object> props) {
        this.dictionaryService.remove(service.getClass().getCanonicalName());

    }

    /**
     * Checks a given passage for spelling errors. A passage is any number of
     * words separated by a space and any of the following punctuation marks:
     * comma (,), period (.), exclamation mark (!), question mark (?),
     * semi-colon (;), and colon(:).
     *
     * @param passage
     *            the passage to spell check.
     * @return An array of misspelled words or null if no words are misspelled.
     */
    public String[] check( String passage )
    {
        // No misspelled words for an empty string.
        if ( ( passage == null ) || ( passage.length() == 0 ) )
        {
            return null;
        }

        List<String> errorList = new ArrayList<String>();

        // Tokenize the passage using spaces and punctionation.
        StringTokenizer st = new StringTokenizer( passage, " ,.!?;:" );

        // Put the current set of services in a local field
        // the field m_svcObjList might be modified concurrently

        // Loop through each word in the passage.
        while ( st.hasMoreTokens() )
        {
            String word = st.nextToken();
            boolean correct = false;

            // Check each available dictionary for the current word.
            for(final DictionaryService dictionary : dictionaryService.values()) {
                if ( dictionary.checkWord( word ) )
                {
                    correct = true;
                }
            }

            // If the word is not correct, then add it
            // to the incorrect word list.
            if ( !correct )
            {
                errorList.add( word );
            }
        }

        // Return null if no words are incorrect.
        if ( errorList.size() == 0 )
        {
            return null;
        }

        // Return the array of incorrect words.
        return errorList.toArray( new String[errorList.size()] );
    }
}