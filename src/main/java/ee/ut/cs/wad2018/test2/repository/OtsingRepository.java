package ee.ut.cs.wad2018.test2.repository;

import ee.ut.cs.wad2018.test2.entity.OtsingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OtsingRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OtsingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OtsingEntity> getOtsingByID(int id) {
        String sql = "select id, otsing, aeg from Otsingud where id = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            OtsingEntity otsingEntity = new OtsingEntity();
            otsingEntity.setId(rs.getInt("id"));
            otsingEntity.setOtsing(rs.getString("otsing"));
            otsingEntity.setAeg(rs.getTimestamp("aeg"));
            return otsingEntity;
        }, id);
    }

    @Transactional
    public int otsingUpdate(String otsingusõne) {
        return jdbcTemplate.update("INSERT INTO otsingud(otsing) VALUES(?)", otsingusõne);
    }

}
