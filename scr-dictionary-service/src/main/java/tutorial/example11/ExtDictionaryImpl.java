package tutorial.example11;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import tutorial.example2.service.DictionaryService;

@Component(immediate = true)
public class ExtDictionaryImpl implements DictionaryService {

    // The set of words contained in the dictionary.
    String[] m_dictionary =
            { "and", "greeting", "service" };

    /**
     * Implements DictionaryService.checkWord(). Determines
     * if the passed in word is contained in the dictionary.
     * @param word the word to be checked.
     * @return true if the word is in the dictionary,
     *         false otherwise.
     **/
    public boolean checkWord(String word)
    {
        word = word.toLowerCase();

        // This is very inefficient
        for (int i = 0; i < m_dictionary.length; i++)
        {
            if (m_dictionary[i].equals(word))
            {
                return true;
            }
        }
        return false;
    }

    @Activate
    public void activate() {
        System.out.println("ExtDictionaryImpl component activated");
        /*
         * The Activate method will be called after any required dependencies
         * have been injected.
         *
         */
    }

    @Deactivate
    public void deactivate() {
        /*
         * The deactivate life-cycle hook will fire only when an activated
         * component component becomes disabled, the component configuration
         * becomes unsatisfied, or the component configuration is no longer
         * needed.
         *
         */
        System.out.println("ExtDictionaryImpl component deactivated");
    }
}
