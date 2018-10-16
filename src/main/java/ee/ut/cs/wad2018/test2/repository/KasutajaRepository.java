package ee.ut.cs.wad2018.test2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class KasutajaRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public KasutajaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int kasutajaUpdate(String nimi,String email,String pilt,String id) {
        return jdbcTemplate.update("INSERT INTO kasutajad(nimi,email,pilt,id) VALUES(?,?,?,?)", nimi,email,pilt,id);
    }
}
