package org.sola.clients.beans.external;

import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.jdesktop.observablecollections.ObservableList;
import org.sola.clients.beans.AbstractIdBean;
import org.sola.clients.beans.cache.CacheManager;
import org.sola.clients.beans.controls.SolaList;
import org.sola.clients.beans.converters.TypeConverters;
import org.sola.clients.beans.referencedata.ClientTypeBean;
import org.sola.services.boundary.wsclients.WSManager;
import org.sola.webservices.transferobjects.EntityAction;
import org.sola.webservices.transferobjects.external.ClientTO;

/**
 * Represents Client object.
 */
public class ClientBean extends AbstractIdBean {
    public static final String USER_ID_PROPERTY = "userId";
    public static final String NAME_PROPERTY = "name";
    public static final String TYPE_CODE_PROPERTY = "typeCode";
    public static final String CLIENT_TYPE_PROPERTY = "clientType";
    public static final String BALANCE_PROPERTY = "balance";
    public static final String SELECTED_CONTACT_PROPERTY = "selectedContact";
    
    private String userId;
    @NotEmpty(message="Name should not be empty.")
    private String name;
    @NotNull(message="Name should not be null.")
    private BigDecimal balance;
    @Size(min=1, message="Enter at least 1 contact.")
    @Valid
    private SolaList<ContactBean> contacts;
    @NotNull(message="Select client type.")
    private ClientTypeBean clientType;
    private transient ContactBean selectedContact;
    
    public ClientBean(){
        super();
        contacts = new SolaList<ContactBean>();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        BigDecimal oldValue = this.balance;
        this.balance = balance;
        propertySupport.firePropertyChange(BALANCE_PROPERTY, oldValue, this.balance);
    }

    public ClientTypeBean getClientType() {
        return clientType;
    }

    public void setClientType(ClientTypeBean clientType) {
        if (this.clientType == null) {
            this.clientType = new ClientTypeBean();
        }
        this.setJointRefDataBean(this.clientType, clientType, CLIENT_TYPE_PROPERTY);
    }

    public SolaList<ContactBean> getContacts() {
        return contacts;
    }

    public ObservableList<ContactBean> getFilteredContacts() {
        return contacts.getFilteredList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        propertySupport.firePropertyChange(NAME_PROPERTY, oldValue, this.name);
    }

    public ContactBean getSelectedContact() {
        return selectedContact;
    }

    public void setSelectedContact(ContactBean selectedContact) {
        ContactBean oldValue = this.selectedContact;
        this.selectedContact = selectedContact;
        propertySupport.firePropertyChange(SELECTED_CONTACT_PROPERTY, oldValue, this.selectedContact);
    }

    public String getTypeCode() {
        if (clientType != null) {
            return clientType.getCode();
        } else {
            return null;
        }
    }

    public void setTypeCode(String typeCode) {
        String oldValue = null;
        if (clientType != null) {
            oldValue = clientType.getCode();
        }
        setClientType(CacheManager.getBeanByCode(CacheManager.getClientTypes(), typeCode));
        propertySupport.firePropertyChange(TYPE_CODE_PROPERTY, oldValue, typeCode);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        String oldValue = this.userId;
        this.userId = userId;
        propertySupport.firePropertyChange(USER_ID_PROPERTY, oldValue, this.userId);
    }
    
    /** Adds new contact person into the list. */
    public void addContact(ContactBean contact){
        if(contact!=null){
            contacts.addAsNew(contact);
        }
    }
    
    /** Removes selected contact person from the list. */
    public void removeSelectedContact(){
        if(selectedContact!=null){
            contacts.safeRemove(selectedContact, EntityAction.DELETE);
        }
    }

    /**
     * Returns client bean, related to lodged user.
     */
    public static ClientBean getClientBean() {
        ClientTO clientTO = WSManager.getInstance().getExternal().getClient();
        return TypeConverters.TransferObjectToBean(clientTO, ClientBean.class, null);
    }

    
    /** Saves client object. */
    public void save(){
        ClientTO clientTO = TypeConverters.BeanToTrasferObject(this, ClientTO.class);
        clientTO = WSManager.getInstance().getExternal().saveClient(clientTO);
        TypeConverters.TransferObjectToBean(clientTO, ClientBean.class, this);
    }
}

