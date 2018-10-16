package ee.ut.cs.wad2018.test2.controller;

import ee.ut.cs.wad2018.test2.entity.OtsingEntity;
import ee.ut.cs.wad2018.test2.service.OtsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController()
public class OtsingController {
    private OtsingService otsingService;

    @Autowired
    public OtsingController(OtsingService otsingService) {
        this.otsingService = otsingService;
    }

    @GetMapping("/otsing")
    public List<OtsingEntity> getOtsingudByID(@RequestParam("id") int id) {
        return otsingService.getOtsingudByID(id);
    }

    @PostMapping("/sisesta")
    public ResponseEntity<Object> sisesta(@RequestParam("otsing") String otsing) throws URISyntaxException {
        otsingService.otsingUpdate(otsing);
        //return back home
        URI uri = new URI("/");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
}
