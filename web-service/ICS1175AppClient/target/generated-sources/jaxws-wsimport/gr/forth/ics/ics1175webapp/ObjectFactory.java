
package gr.forth.ics.ics1175webapp;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gr.forth.ics.ics1175webapp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SearchTermResponse_QNAME = new QName("http://ics1175webapp.ics.forth.gr/", "searchTermResponse");
    private final static QName _SearchTerm_QNAME = new QName("http://ics1175webapp.ics.forth.gr/", "searchTerm");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gr.forth.ics.ics1175webapp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchTermResponse }
     * 
     */
    public SearchTermResponse createSearchTermResponse() {
        return new SearchTermResponse();
    }

    /**
     * Create an instance of {@link SearchTerm }
     * 
     */
    public SearchTerm createSearchTerm() {
        return new SearchTerm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchTermResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ics1175webapp.ics.forth.gr/", name = "searchTermResponse")
    public JAXBElement<SearchTermResponse> createSearchTermResponse(SearchTermResponse value) {
        return new JAXBElement<SearchTermResponse>(_SearchTermResponse_QNAME, SearchTermResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchTerm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ics1175webapp.ics.forth.gr/", name = "searchTerm")
    public JAXBElement<SearchTerm> createSearchTerm(SearchTerm value) {
        return new JAXBElement<SearchTerm>(_SearchTerm_QNAME, SearchTerm.class, null, value);
    }

}
