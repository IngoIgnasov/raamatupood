package ee.ut.cs.wad2018.test2.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class KasutajaRepository {
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public int kasutajaUpdate(String nimi,String email,String pilt,String id) {
        return jdbcTemplate.update("INSERT INTO kasutajad(nimi,email,pilt,id) VALUES(?,?,?,?)", nimi,email,pilt,id);
    }
}
