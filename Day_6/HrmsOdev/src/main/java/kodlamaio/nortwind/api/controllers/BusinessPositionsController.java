package kodlamaio.nortwind.api.controllers;

import kodlamaio.nortwind.business.abstracts.BusinessPositionService;
import kodlamaio.nortwind.entities.concretes.BusinessPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/businesspositions")
public class BusinessPositionsController {

    private BusinessPositionService businessPositionService;

    @Autowired
    public BusinessPositionsController(BusinessPositionService businessPositionService){
        super();
        this.businessPositionService = businessPositionService;
    }


    @GetMapping("/getall")
    public List<BusinessPosition> getAll(){
        return  this.businessPositionService.getAll();
    }
}
