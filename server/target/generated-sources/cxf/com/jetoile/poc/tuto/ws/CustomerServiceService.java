
/*
 * 
 */

package com.jetoile.poc.tuto.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.5
 * Wed Feb 01 20:29:41 CET 2012
 * Generated source version: 2.2.5
 * 
 */


@WebServiceClient(name = "CustomerServiceService", 
                  wsdlLocation = "file:/home/khanh/netbeans-workspace/cxf-project-parent/wsdl/src/main/resources/HelloService.wsdl",
                  targetNamespace = "http://ws.tuto.poc.jetoile.com/") 
public class CustomerServiceService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://ws.tuto.poc.jetoile.com/", "CustomerServiceService");
    public final static QName CustomerServiceImplPort = new QName("http://ws.tuto.poc.jetoile.com/", "CustomerServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/khanh/netbeans-workspace/cxf-project-parent/wsdl/src/main/resources/HelloService.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/home/khanh/netbeans-workspace/cxf-project-parent/wsdl/src/main/resources/HelloService.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public CustomerServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns CustomerService
     */
    @WebEndpoint(name = "CustomerServiceImplPort")
    public CustomerService getCustomerServiceImplPort() {
        return super.getPort(CustomerServiceImplPort, CustomerService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerService
     */
    @WebEndpoint(name = "CustomerServiceImplPort")
    public CustomerService getCustomerServiceImplPort(WebServiceFeature... features) {
        return super.getPort(CustomerServiceImplPort, CustomerService.class, features);
    }

}