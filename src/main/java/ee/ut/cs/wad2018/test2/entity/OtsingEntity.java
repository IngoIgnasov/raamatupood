package ee.ut.cs.wad2018.test2.entity;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OtsingEntity {

        private int id;
        private String otsing;
        private Timestamp aeg;

}
