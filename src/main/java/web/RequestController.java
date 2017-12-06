package web;

import entity.Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    @RequestMapping(value="/create", method= RequestMethod.POST, produces="application/json", consumes="application/json")
    public void createStudent(@RequestBody Request request)
    {

    }

    @RequestMapping(value="/requests/{customer}",produces="application/json", method=RequestMethod.GET)
    public List<Request> getRequestsByCustomer(@PathVariable("customer") String customer)
    {
        return null;
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
    public void updateStatus(@RequestBody Request request)
    {

    }

    @RequestMapping(value="/delete/{customer}",method = RequestMethod.DELETE, produces="application/json")
    public void deleteRequestsByCustomer(@PathVariable("customer") String customer)
    {

    }
}
