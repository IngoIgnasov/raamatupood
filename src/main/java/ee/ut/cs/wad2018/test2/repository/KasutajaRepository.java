package ee.ut.cs.wad2018.test2.repository;

import ee.ut.cs.wad2018.test2.entity.KasutajaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KasutajaRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public KasutajaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int kasutajaUpdate(String nimi,String email,String pilt, String id) {
        return jdbcTemplate.update("INSERT INTO kasutajad(nimi,email,pilt, id) VALUES(?,?,?,?)", nimi,email,pilt,id);
    }

    @Transactional
    public List<KasutajaEntity> getKasutajaById(String id) {
        String sql = "SELECT * FROM kasutajad WHERE ID = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return mapValuesFromDBtoKasutajaEntity(rs);
        }, id);

    }

    private KasutajaEntity mapValuesFromDBtoKasutajaEntity(ResultSet rs) throws SQLException {
        KasutajaEntity kasutajaEntity = new KasutajaEntity();
        kasutajaEntity.setEmail(rs.getString("nimi"));
        kasutajaEntity.setNimi(rs.getString("email"));
        kasutajaEntity.setPilt(rs.getString("pilt"));
        kasutajaEntity.setId(rs.getString("id"));
        return kasutajaEntity;
    }

}
