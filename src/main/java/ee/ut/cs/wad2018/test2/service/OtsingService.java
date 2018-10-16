package ee.ut.cs.wad2018.test2.service;

import ee.ut.cs.wad2018.test2.entity.OtsingEntity;
import ee.ut.cs.wad2018.test2.repository.OtsingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtsingService {
    private OtsingRepository otsingRepository;

    @Autowired
    public OtsingService(OtsingRepository otsingRepository) {
        this.otsingRepository = otsingRepository;
    }

    public List<OtsingEntity> getOtsingudByID(int id) {
        return otsingRepository.getOtsingByID(id);
    }

    public void otsingUpdate(String otsing){
        otsingRepository.otsingUpdate(otsing);
    }
}
