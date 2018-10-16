package ee.ut.cs.wad2018.test2.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class KasutajaRepository {
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public int kasutajaUpdate(Integer id,String nimi,String email,String pilt) {
        return jdbcTemplate.update("INSERT INTO kasutajad(otsing) VALUES(?,?,?,?)", id,nimi,email,pilt);
    }
}
