package org.sola.clients.beans.external;

import java.util.List;
import org.sola.clients.beans.AbstractBindingBean;
import org.sola.clients.beans.controls.SolaObservableList;
import org.sola.clients.beans.converters.TypeConverters;
import org.sola.services.boundary.wsclients.WSManager;

/**
 * Holds list of {@link RequestBean} objects.
 */
public class RequestListBean extends AbstractBindingBean {
    public static final String SELECTED_REQUEST_PROPERTY = "selectedRequest";

    private SolaObservableList<RequestBean> requests;
    private RequestBean selectedRequest;
    
    public RequestListBean(){
        super();
        requests = new SolaObservableList<RequestBean>();
    }

    public SolaObservableList<RequestBean> getRequests() {
        return requests;
    }

    public RequestBean getSelectedRequest() {
        return selectedRequest;
    }

    public void setSelectedRequest(RequestBean selectedRequest) {
        RequestBean oldValue = this.selectedRequest;
        this.selectedRequest = selectedRequest;
        propertySupport.firePropertyChange(SELECTED_REQUEST_PROPERTY, oldValue, this.selectedRequest);
    }
    
    /** Refreshes list of requests. */
    public void refresh(){
        TypeConverters.TransferObjectListToBeanList(
                WSManager.getInstance().getExternal().getClientRequests(),
                RequestBean.class, (List)requests);
    }
}

