package ee.ut.cs.wad2018.test2.repository;

import ee.ut.cs.wad2018.test2.entity.ActorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class DataRepository {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "hiljemmuudame";
    private JdbcTemplate jdbcTemplate;






    // This code origin is from http://www.postgresqltutorial.com/postgresql-jdbc/connecting-to-postgresql-database/
    public Connection connection() throws Exception{
        Connection connection;
        try{
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            throw new Exception(e.getMessage());
        }
        return connection;
    }
    public void countRows() throws Exception{
        String SQLstatment = "SELECT count(*) FROM actor";

        try(Connection connection = this.connection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLstatment);
            System.out.println(resultSet);
        }catch(SQLException e){
            throw new Exception("No connection with databaseeeeee");
        }
    }




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
