package com.kenneth;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

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
		JAXBContext jc = JAXBContext.newInstance(Purchase.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();

        ClassLoader classLoader = Purchase.class.getClassLoader();
        InputStream xmlStream = classLoader.getResourceAsStream("xmlfiles/f1.xml");
        StreamSource xmlSource = new StreamSource(xmlStream);
		Purchase purchase = (Purchase) unmarshaller.unmarshal(xmlSource);
		System.out.println(purchase.getPaymentMethod().toString());
	}

	private void marshal() throws Exception {
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
		
		// TODO schema validation
		
		/*
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        
        ClassLoader classLoader = Purchase.class.getClassLoader();
        InputStream xsdStream = classLoader.getResourceAsStream("schema/Main.xsd");
        StreamSource xsdSource = new StreamSource(xsdStream);
        Schema schema = sf.newSchema(xsdSource);
        
		marshaller.setSchema(schema);
		marshaller.marshal(purchase, System.out);
		
		*/
	}
}
