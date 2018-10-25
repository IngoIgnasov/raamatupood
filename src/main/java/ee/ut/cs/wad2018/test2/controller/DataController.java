package ee.ut.cs.wad2018.test2.controller;

import ee.ut.cs.wad2018.test2.entity.ActorEntity;
import ee.ut.cs.wad2018.test2.entity.BookAmntByCtgryResultentity;
import ee.ut.cs.wad2018.test2.entity.RaamatEntity;
import ee.ut.cs.wad2018.test2.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class DataController {
    private DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    /**
     * @GetMapping("/test") public List<ActorEntity> getActorsByName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
     * return dataService.getActorsByName(firstName, lastName);
     * }
     */
    @PostMapping("/postraamat")
    public List<RaamatEntity> getRaamatudByName(@RequestParam("name") String name, @RequestParam("author") String author) {
        return dataService.getRaamatudByName(name, author);
    }

    @PostMapping("/allraamatud")
    public List<RaamatEntity> getAllBooks() {
        return dataService.getAllRaamatud();
    }
    @PostMapping("/byCategory")
    public List<BookAmntByCtgryResultentity> getAmountByCategory(){
        return dataService.getAmountByCategory();
    }

}
