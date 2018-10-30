package ee.ut.cs.wad2018.test2.security.smartid;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Verification {

    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
