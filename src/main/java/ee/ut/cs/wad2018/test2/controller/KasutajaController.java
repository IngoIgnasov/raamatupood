package ee.ut.cs.wad2018.test2.controller;

import ee.ut.cs.wad2018.test2.service.KasutajaService;
import ee.ut.cs.wad2018.test2.service.OtsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class KasutajaController {
    private KasutajaService kasutajaService;

    @Autowired
    public KasutajaController(KasutajaService kasutajaService) {
        this.kasutajaService = kasutajaService;
    }

    @PostMapping("/addKasutaja")
    public ResponseEntity<Object> addKasutaja(@RequestParam("nimi") String nimi,@RequestParam("email") String email,
                                              @RequestParam("pilt") String pilt,@RequestParam("id") String id) throws URISyntaxException {
        kasutajaService.kasutajaUpdate(nimi,email,pilt,id);
        //return back home
        URI uri = new URI("/");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
}
