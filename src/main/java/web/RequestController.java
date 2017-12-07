package web;

import dao.RequestDao;
import entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class RequestController {

    @Autowired
    RequestDao dao;

    @RequestMapping(value="/create", method= RequestMethod.POST, produces="application/json", consumes="application/json")
    public Request createStudent(@RequestBody Request request)
    {
        dao.createRequest(request.getId(), request.getCustomer(), request.getStartDate(), request.getEndDate(), request.getStatus());
        return request;
    }

    @RequestMapping(value="/requests/{customer}",produces="application/json", method=RequestMethod.GET)
    public List<Request> getRequestsByCustomer(@PathVariable("customer") String customer) {
        return dao.getRequestByCustomer(customer);
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
    public Request updateStatus(@RequestBody Request request)
    {
        dao.updateRequestStatus(request.getId(), request.getStatus());
        return request;
    }

    @RequestMapping(value="/delete/{customer}",method = RequestMethod.DELETE, produces="application/json")
    public String deleteRequestsByCustomer(@PathVariable("customer") String customer)
    {
        dao.deleteRequestByCustomer(customer);
        return customer;
    }
}
