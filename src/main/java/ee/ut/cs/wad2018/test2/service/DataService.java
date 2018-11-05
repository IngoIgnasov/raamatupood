package ee.ut.cs.wad2018.test2.service;

import ee.ut.cs.wad2018.test2.entity.ActorEntity;
import ee.ut.cs.wad2018.test2.entity.BookAmntByCtgryResultentity;
import ee.ut.cs.wad2018.test2.entity.RaamatEntity;
import ee.ut.cs.wad2018.test2.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    private DataRepository dataRepository;


    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<RaamatEntity> getRaamatudByName(String name, String author) {
        return dataRepository.getRaamatByNameAndAuthor(name, author);
    }

    public List<RaamatEntity> getAllRaamatud() {
        return dataRepository.getAllBooks();
    }

    public List<RaamatEntity> getRaamatudByCategory(String category) {
        return dataRepository.getRaamatudByCategory(category);
    }

    public List<BookAmntByCtgryResultentity> getAmountByCategory() {
        return dataRepository.getAmountByCategory();
    }
}
