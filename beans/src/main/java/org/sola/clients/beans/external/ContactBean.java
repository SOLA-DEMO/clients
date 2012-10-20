package org.sola.clients.beans.external;

import org.hibernate.validator.constraints.NotEmpty;
import org.sola.clients.beans.AbstractIdBean;

/**
 * Represents Contact object.
 */
public class ContactBean extends AbstractIdBean {
    
    public static final String CLIENT_ID_PROPERTY = "clientId";
    public static final String NAME_PROPERTY = "name";
    public static final String PHONE_NUMBER_PROPERTY = "phoneNumber";
    
    private String clientId;
    @NotEmpty(message="Name should not be empty.")
    private String name;
    @NotEmpty(message="Phone number should not be empty.")
    private String phoneNumber;
    
    public ContactBean(){
        super();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        String oldValue = this.clientId;
        this.clientId = clientId;
        propertySupport.firePropertyChange(CLIENT_ID_PROPERTY, oldValue, this.clientId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        propertySupport.firePropertyChange(NAME_PROPERTY, oldValue, this.name);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String oldValue = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        propertySupport.firePropertyChange(PHONE_NUMBER_PROPERTY, oldValue, this.phoneNumber);
    }
}

