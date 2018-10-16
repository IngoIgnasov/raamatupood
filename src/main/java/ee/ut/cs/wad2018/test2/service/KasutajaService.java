package ee.ut.cs.wad2018.test2.service;

import ee.ut.cs.wad2018.test2.repository.KasutajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KasutajaService {
    private KasutajaRepository kasutajaRepository;

    @Autowired
    public KasutajaService(KasutajaRepository kasutajaRepository) {
        this.kasutajaRepository = kasutajaRepository;
    }


    public void kasutajaUpdate(String nimi,String email,String pilt,String id){
        kasutajaRepository.kasutajaUpdate(nimi,email,pilt,id);
    }

}
