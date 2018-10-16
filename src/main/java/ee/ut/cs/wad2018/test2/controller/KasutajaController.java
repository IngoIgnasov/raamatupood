package ee.ut.cs.wad2018.test2.controller;

import ee.ut.cs.wad2018.test2.service.KasutajaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class KasutajaController {
    private KasutajaService kasutajaService;

    @PostMapping("/addKasutaja")
    public ResponseEntity<Object> addKasutaja(@RequestParam("id") Integer id,@RequestParam("nimi") String nimi,@RequestParam("email") String email,
                                              @RequestParam("pilt") String pilt) throws URISyntaxException {
        kasutajaService.kasutajaUpdate(id,nimi,email,pilt);
        //return back home
        URI uri = new URI("/");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
}
