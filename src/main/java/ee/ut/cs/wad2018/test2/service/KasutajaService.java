package ee.ut.cs.wad2018.test2.service;

import ee.ut.cs.wad2018.test2.repository.KasutajaRepository;
import org.springframework.stereotype.Service;

@Service
public class KasutajaService {
    private KasutajaRepository kasutajaRepository;
    public void kasutajaUpdate(String id,String nimi,String email,String pilt){
        kasutajaRepository.kasutajaUpdate(id,nimi,email,pilt);
    }

}
