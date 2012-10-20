package org.sola.clients.beans.referencedata;

import org.jdesktop.observablecollections.ObservableList;
import org.sola.clients.beans.AbstractBindingListBean;
import org.sola.clients.beans.cache.CacheManager;
import org.sola.clients.beans.controls.SolaCodeList;

/**
 * Holds list of {@link ClientTypeBean} objects.
 */
public class ClientTypeListBean extends AbstractBindingListBean {
    
    public static final String SELECTED_CLIENT_TYPE_PROPERTY = "selectedClientType";
    private SolaCodeList<ClientTypeBean> clientTypes;
    private ClientTypeBean selectedClientType;
    
    /** Default constructor. */
    public ClientTypeListBean(){
        this(false);
    }
    
    /** 
     * Creates object instance.
     * @param createDummy Indicates whether to add empty object on the list.
     */
    public ClientTypeListBean(boolean createDummy) {
        super();
        clientTypes = new SolaCodeList<ClientTypeBean>();
        loadList(createDummy);
    }
    
    /** 
     * Loads list of {@link ClientTypeBean}.
     * @param createDummy Indicates whether to add empty object on the list.
     */
    public final void loadList(boolean createDummy) {
        loadCodeList(ClientTypeBean.class, clientTypes, 
                CacheManager.getClientTypes(), createDummy);
    }

    public ObservableList<ClientTypeBean> getClientTypes() {
        return clientTypes.getFilteredList();
    }

    public ClientTypeBean getSelectedClientType() {
        return selectedClientType;
    }

    public void setSelectedClientType(ClientTypeBean selectedClientType) {
        this.selectedClientType = selectedClientType;
        ClientTypeBean oldValue = this.selectedClientType;
        this.selectedClientType = selectedClientType;
        propertySupport.firePropertyChange(SELECTED_CLIENT_TYPE_PROPERTY, 
                oldValue, this.selectedClientType);
    }
}

