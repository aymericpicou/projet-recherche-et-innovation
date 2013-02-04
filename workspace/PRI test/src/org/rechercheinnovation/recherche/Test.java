package org.rechercheinnovation.recherche;




import java.io.FileInputStream;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Pointer;
import net.didion.jwnl.data.PointerType;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.data.relationship.*;
import net.didion.jwnl.dictionary.Dictionary;
/**
 * Hello world!
 *
 */
public class Test
{
	  public static void main( String[] args ) throws JWNLException
	    
	    {
	      /*
	        configureJWordNet();
	        Dictionary dictionary = Dictionary.getInstance();
	        
	        IndexWord word = dictionary.lookupIndexWord(POS.NOUN, "auditory_communication");
	        System.out.println("Senses of the word 'car':");
	        
	        Synset[] senses = word.getSenses();
	      
	        int i=0;
	          Synset sense = senses[i];
	          
	          System.out.println((i+1) + ". " + sense.getGloss());
	          Pointer[] holo = sense.getPointers(PointerType.HYPONYM);
	          
	          
	         for (int j=0; j<holo.length; j++) {
	            Synset synset = (Synset) (holo[j].getTarget());
	            
	            Word synsetWord = synset.getWord(0);
	            System.out.print("  -part-of-> " + synsetWord.getLemma()+"\n");
	            //System.out.println(" = " + synset.getGloss());
	            
	        
	            
	         
	         
	        }*/
		  System.out.println(gethypernymes("tennis"));

	    }
	        
	        
	        
	        public static void configureJWordNet() {
	            // WARNING: This still does not work in Java 5!!!
	            try {
	                // initialize JWNL (this must be done before JWNL can be used)
	                // See the JWordnet documentation for details on the properties file
	                JWNL.initialize(new FileInputStream("C:\\Users\\aymeric\\workspace\\PRI test\\jwnl14-rc2\\config\\file_properties.xml"));
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                System.exit(-1);
	            }
	        }
	        public static String[] gethypernymes(String mot) throws JWNLException{
	        	String[] hypernymes=null;
	        	configureJWordNet();
		        Dictionary dictionary = Dictionary.getInstance();
		        IndexWord word = dictionary.lookupIndexWord(POS.NOUN, mot);
		        Synset[] senses = word.getSenses();
			      
		        int i=0;
		          Synset sense = senses[i];
		          
		          System.out.println((i+1) + ". " + sense.getGloss());
		          Pointer[] holo = sense.getPointers(PointerType.SUBSTANCE_HOLONYM);
		          
		          System.out.println(holo.length);
		         for (int j=0; j<holo.length; j++) {
		            Synset synset = (Synset) (holo[j].getTarget());
		            
		            Word synsetWord = synset.getWord(0);
		            
		           // hypernymes[j] = synsetWord.getLemma();
		            System.out.println(" = " + synset.getGloss());
		            
		        
		            
		         
		         
		        }
	        	return hypernymes;
	        }
	        
}
