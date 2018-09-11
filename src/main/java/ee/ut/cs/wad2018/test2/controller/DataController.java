package ee.ut.cs.wad2018.test2.controller;

import ee.ut.cs.wad2018.test2.entity.ActorEntity;
import ee.ut.cs.wad2018.test2.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/test")
public class DataController {
    private DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<ActorEntity> getActorsByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return dataService.getActorsByName(firstName, lastName);
    }

}
