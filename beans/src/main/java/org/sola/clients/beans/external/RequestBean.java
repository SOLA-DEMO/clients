package org.sola.clients.beans.external;

import java.math.BigDecimal;
import java.util.Date;
import org.sola.clients.beans.AbstractIdBean;
import org.sola.clients.beans.administrative.BaUnitBean;
import org.sola.clients.beans.converters.TypeConverters;
import org.sola.services.boundary.wsclients.WSManager;

/**
 * Represents Request object.
 */
public class RequestBean extends AbstractIdBean {

    public static final String CLIENT_ID_PROPERTY = "clientId";
    public static final String NAME_FIRST_PART_PROPERTY = "nameFirstPart";
    public static final String NAME_LAST_PART_PROPERTY = "nameLastPart";
    public static final String DATE_PROPERTY = "date";
    public static final String COST_PROPERTY = "cost";
    
    private String clientId;
    private String nameFirstPart;
    private String nameLastPart;
    private Date date;
    private BigDecimal cost;
    
    public RequestBean(){
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        BigDecimal oldValue = this.cost;
        this.cost = cost;
        propertySupport.firePropertyChange(COST_PROPERTY, oldValue, this.cost);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldValue = this.date;
        this.date = date;
        propertySupport.firePropertyChange(DATE_PROPERTY, oldValue, this.date);
    }

    public String getNameFirstPart() {
        return nameFirstPart;
    }

    public void setNameFirstPart(String nameFirstPart) {
        String oldValue = this.nameFirstPart;
        this.nameFirstPart = nameFirstPart;
        propertySupport.firePropertyChange(NAME_FIRST_PART_PROPERTY, oldValue, this.nameFirstPart);
    }

    public String getNameLastPart() {
        return nameLastPart;
    }

    public void setNameLastPart(String nameLastPart) {
        String oldValue = this.nameLastPart;
        this.nameLastPart = nameLastPart;
        propertySupport.firePropertyChange(NAME_LAST_PART_PROPERTY, oldValue, this.nameLastPart);
    }
    
    /** Sends request to get property object. */
    public static BaUnitBean makeRequest(String nameFirstPart, String nameLastPart){
        return TypeConverters.TransferObjectToBean(
                WSManager.getInstance().getExternal().makeRequest(nameFirstPart, nameLastPart),
                BaUnitBean.class, null);
    }
}

