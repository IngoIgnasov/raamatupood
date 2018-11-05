package ee.ut.cs.wad2018.test2.repository;

import ee.ut.cs.wad2018.test2.entity.ActorEntity;
import ee.ut.cs.wad2018.test2.entity.BookAmntByCtgryResultentity;
import ee.ut.cs.wad2018.test2.entity.RaamatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DataRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ActorEntity> getActorByName(String firstName, String lastName) {
        String sql = "select actor_id, first_name, last_name, last_update from actor where first_name = ? and last_name = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            ActorEntity actorEntity = new ActorEntity();
            actorEntity.setId(rs.getLong("actor_id"));
            actorEntity.setFirstName(rs.getString("first_name"));
            actorEntity.setLastName(rs.getString("last_name"));
            return actorEntity;
        }, firstName, lastName);

    }

    public List<RaamatEntity> getRaamatByNameAndAuthor(String name, String author) {
        String sql = "select * from raamatud where pealkiri = ? and autor = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return mapValuesFromDBtoRaamarEntity(rs);
        }, name, author);

    }

    public List<BookAmntByCtgryResultentity> getAmountByCategory() {
        String sql = "select kategooria,COUNT(*) as arv from raamatud_2_kategooriad group by kategooria";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BookAmntByCtgryResultentity bookAmntByCtgryResultentity = new BookAmntByCtgryResultentity();
            bookAmntByCtgryResultentity.setKategooria(rs.getString("kategooria"));
            bookAmntByCtgryResultentity.setArv(rs.getInt("arv"));
            return bookAmntByCtgryResultentity;
        });
    }

    public List<RaamatEntity> getRaamatudByCategory(String category){
        String sql = "select * from raamatud,kategooriad,raamatud_2_kategooriad where kategooria = ? and pealkiri = raamatunimi and autor = raamatuautor and nimetus = kategooria";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return mapValuesFromDBtoRaamarEntity(rs);
        },category);
    }

    public List<RaamatEntity> getAllBooks() {
        String sql = "select * from raamatud";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return mapValuesFromDBtoRaamarEntity(rs);
        });

    }

    private RaamatEntity mapValuesFromDBtoRaamarEntity(ResultSet rs) throws SQLException {
        RaamatEntity raamatEntity = new RaamatEntity();
        raamatEntity.setPealkiri(rs.getString("pealkiri"));
        raamatEntity.setAutor(rs.getString("autor"));
        raamatEntity.setKirjastus(rs.getString("kirjastus"));
        raamatEntity.setLk(rs.getInt("lk"));
        raamatEntity.setClickide_arv(rs.getInt("clickide_arv"));
        raamatEntity.setLisamise_aeg(rs.getTimestamp("lisamise_aeg"));
        raamatEntity.setHind(rs.getInt("hind"));
        raamatEntity.setPilt(rs.getBytes("pilt"));
        raamatEntity.setKogus(rs.getInt("kogus"));
        return raamatEntity;
    }
}
