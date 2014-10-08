package tbx2rdf.vocab;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 * Class with some common static terms 
 * @author vroddon
 */
public class ONTOLEX {
	private static Model defaultModel = ModelFactory.createDefaultModel(); 
	public static Property lexicalizedSense = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#lexicalizedSense");
	public static Property writtenRep = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#writtenRep");
	public static Property language = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#language");
	public static Property entry = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#entry");
	public static Property sense = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#sense");
	public static Property canonicalForm = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#canonicalForm");
	public static Property constituent = defaultModel.createProperty("http://www.w3.org/ns/decomp#constituent");
	public static Property otherForm = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#otherForm");
	public static Property identifies = defaultModel.createProperty("http://www.w3.org/ns/decomp#identifies");
	public static Property definition = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#definition");
	public static Property reference = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#reference");
	 
	
	
	public static Resource Lexicon = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#Lexicon");
	public static Resource LexicalEntry = defaultModel.createProperty("http://www.w3.org/ns/lemon/ontolex#LexicalEntry");
    
     
     
       
     
}
