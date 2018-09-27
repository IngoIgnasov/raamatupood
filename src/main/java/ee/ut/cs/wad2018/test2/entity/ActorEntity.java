package ee.ut.cs.wad2018.test2.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ActorEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private OffsetDateTime lastUpdate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastUpdate(OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }
}
