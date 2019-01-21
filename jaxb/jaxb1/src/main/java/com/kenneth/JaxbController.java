package com.kenneth;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.namespacetest.commontypes.AddressType;
import com.namespacetest.commontypes.PaymentMethodType;
import com.namespacetest.customertypes.CustomerType;
import com.namespacetest.purchase.Purchase;

@Named
@ViewScoped
public class JaxbController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doIt() {
		try {
			marshal();
			unmarshal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void unmarshal() throws Exception {
		
		System.out.println("Entering unmarshal");
		
		JAXBContext jc = JAXBContext.newInstance(Purchase.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();

        ClassLoader classLoader = Purchase.class.getClassLoader();
        InputStream xmlStream = classLoader.getResourceAsStream("xmlfiles/f1.xml");
        StreamSource xmlSource = new StreamSource(xmlStream);
		
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        
		URL file = Purchase.class.getClassLoader().getResource("schema/Main.xsd");

		Schema schema = sf.newSchema(file);
      
		unmarshaller.setSchema(schema);
        
        Purchase purchase = (Purchase) unmarshaller.unmarshal(xmlSource);
		System.out.println(purchase.getPaymentMethod().toString());
	}

	private void marshal() throws Exception {
		
		System.out.println("Entering marshal");

		System.out.println("Marshalling without schema validation");

		JAXBContext jc = JAXBContext.newInstance(Purchase.class);

		CustomerType customerType = new CustomerType();
		
		AddressType billingAddress = new AddressType();
		billingAddress.setLine1("Skolgatan 21");
		billingAddress.setLine2("88250 Långsele");
		customerType.setBillingAddress(billingAddress);
		AddressType deliveryAddress = new AddressType();
		deliveryAddress.setLine1("Norra Fagerviksvägen 1");
		deliveryAddress.setLine2("86030 Sörberge");
		customerType.setDeliveryAddress(deliveryAddress );
		
		customerType.setName("Lars Bandage");
		Purchase purchase = new Purchase();
		purchase.setPaymentMethod(PaymentMethodType.MASTER_CARD);
		purchase.setCustomerDetails(customerType);

		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(purchase, System.out);

		System.out.println("Marshalling with schema validation");

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
		URL file = Purchase.class.getClassLoader().getResource("schema/Main.xsd");

        Schema schema = sf.newSchema(file);
        
		marshaller.setSchema(schema);
		marshaller.marshal(purchase, System.out);
	}
}
