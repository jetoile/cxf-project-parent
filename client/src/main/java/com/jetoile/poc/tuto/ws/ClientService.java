/*
 * Copyright (c) 2011 Khanh Tuong Maudoux <kmx.petals@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jetoile.poc.tuto.ws;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;

/**
 * @author khanh
 */
public final class ClientService {

    private static final QName SERVICE_NAME =
            new QName("http://ws.tuto.poc.jetoile.com/",
                    "CustomerServiceImplService");

    private ClientService() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = new URL("http://localhost:8080/webapp-1.0-SNAPSHOT/services/Customer?wsdl");

        System.out.println(wsdlURL);
        CustomerServiceService ss = new CustomerServiceService(wsdlURL, SERVICE_NAME);
        CustomerService port = ss.getCustomerServiceImplPort();

        // Set request context property.
        //java.util.Map<String, Object> requestContext = ((javax.xml.ws.BindingProvider) port).getRequestContext();
        //requestContext.put(ContextPropertyName, PropertyValue);

        System.out.println("Invoking sayHi...");
        List<Customer> response = port.getCustomersByName("");
        System.out.println("Server responded with: " + response);

        System.out.println("Invoking greetMe...");
        Customer customer = new Customer();
        port.updateCustomer(customer);
        System.exit(0);
    }
}
