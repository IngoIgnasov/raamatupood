package ee.ut.cs.wad2018.test2.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RaamatEntity {

    private String pealkiri;
    private String autor;
    private String kirjastus;
    private int lk;
    private int clickide_arv;
    private Timestamp lisamise_aeg;
    private int hind;
    private byte[] pilt;
}
