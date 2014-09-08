package tbx2rdf.types;

import com.hp.hpl.jena.graph.NodeFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.DCTerms;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

import org.w3c.dom.NodeList;

import tbx2rdf.DatatypePropertyMapping;
import tbx2rdf.IndividualMapping;
import tbx2rdf.Mapping;
import tbx2rdf.Mappings;
import tbx2rdf.ObjectPropertyMapping;
import tbx2rdf.types.abs.impIDLangTypeTgtDtyp;

public class AdminInfo extends impIDLangTypeTgtDtyp {
    public final NodeList value;

    public AdminInfo(NodeList value, Mapping type, String lang, Mappings mappings) {
        super(type, lang, mappings);
        this.value = value;
    }

    @Override
    public void toRDF(Model model, Resource parent) {
        if(type == null) {
            System.err.println("Null type ignored!");
        } else if(type instanceof ObjectPropertyMapping) {
        	
        	
        	if (((ObjectPropertyMapping) type).getTargetAtttribute() != null)
      	   	{
      		   parent.addProperty(model.createProperty(type.getURL()), model.createResource(target));
         	}
      	   
      	   else if (((ObjectPropertyMapping) type).getAllowedValues() != null)
      	   {
      			if (((ObjectPropertyMapping) type).getAllowedValues().contains(nodelistToString(value)))
         		{
           		   parent.addProperty(model.createProperty(type.getURL()), model.createResource("tbx:"+nodelistToString(value)));

         		}
         		else
         		{
         			throw new RuntimeException("Undefined value: "+target+" for type"+ "<type>" +" in element TermNote!\n");
         		}
      	   }
      	   
      	   else
      	   {
      		   Resource myRes = model.createResource("someNewResource");
         			
         		parent.addProperty(model.createProperty(type.getURL()), myRes );
         		model.add(myRes,RDFS.label, model.createLiteral(nodelistToString(value)));
         	}
        	
        } else if(type instanceof DatatypePropertyMapping) {
            if(datatype != null) {
                parent.addProperty(model.createProperty(type.getURL()), nodelistToString(value), NodeFactory.getType(datatype));
            } else {
                parent.addProperty(model.createProperty(type.getURL()), nodelistToString(value), lang);
            }
            if(target != null && !target.equals("")) {
                parent.addProperty(DCTerms.source, model.createResource(target));
            }
        } else if(type instanceof IndividualMapping) {
            System.err.println("Using individual mapping as a property! <" + type.getURL() + ">");
            parent.addProperty(model.createProperty(type.getURL()), model.createResource(target));
        } else {
            throw new RuntimeException("Unexpected mapping type: " + type);
        }
    }
    

}
