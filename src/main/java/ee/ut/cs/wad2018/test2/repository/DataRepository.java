package ee.ut.cs.wad2018.test2.repository;

import ee.ut.cs.wad2018.test2.entity.ActorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
