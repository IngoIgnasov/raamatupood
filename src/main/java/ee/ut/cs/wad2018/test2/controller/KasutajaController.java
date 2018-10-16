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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

@Controller
public class KasutajaController {
    private KasutajaService kasutajaService;

    @Autowired
    public KasutajaController(KasutajaService kasutajaService) {
        this.kasutajaService = kasutajaService;
    }

    @PostMapping("/addKasutaja")
    public ResponseEntity<Object> addKasutaja(@RequestParam("token") String token) throws URISyntaxException, GeneralSecurityException, IOException {
        kasutajaService.kasutajaUpdate(token);
        //return back home
        return "redirect:" + "/";

    }
}
