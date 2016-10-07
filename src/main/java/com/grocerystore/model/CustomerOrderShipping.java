package com.grocerystore.model;

public class CustomerOrderShipping {

    private Integer idCustomerOrder;
    private Integer id_shipping;
    private int status;

    public Integer getIdCustomerOrder() {
        return idCustomerOrder;
    }
    public void setIdCustomerOrder(Integer idCustomerOrder) {
        this.idCustomerOrder = idCustomerOrder;
    }
    public Integer getId_shipping() {
        return id_shipping;
    }
    public void setId_shipping(Integer id_shipping) {
        this.id_shipping = id_shipping;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "CustomerOrderShipping [idCustomerOrder=" + idCustomerOrder
                + ", id_shipping=" + id_shipping + ", status=" + status + "]";
    }

}
