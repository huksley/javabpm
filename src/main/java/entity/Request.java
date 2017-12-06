package entity;

import java.util.Date;

public class Request {
    Long id;
    String customer;
    Date startDate;
    Date endDate;
    Integer status;

    public Request(Long id, String customer, Date startDate, Date endDate, Integer status) {
        this.id = id;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Request(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
