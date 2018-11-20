package ee.ut.cs.wad2018.test2.service;

import com.google.api.client.auth.openidconnect.IdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import ee.ut.cs.wad2018.test2.repository.KasutajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class KasutajaService {
    private KasutajaRepository kasutajaRepository;


    @Autowired
    public KasutajaService(KasutajaRepository kasutajaRepository) {
        this.kasutajaRepository = kasutajaRepository;
    }


    public void kasutajaUpdate(String token) throws IOException, GeneralSecurityException {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
                //LocalHost: 66371768338-mf99pfhna7qifve1b46s5595204ssas8.apps.googleusercontent.com
                //Heroku: 340061687253-aemesn4rershit8q67pemdjl8itm6la0.apps.googleusercontent.com
                .setAudience(Collections.singletonList("340061687253-aemesn4rershit8q67pemdjl8itm6la0.apps.googleusercontent.com"))
                .build();

        GoogleIdToken idToken = verifier.verify(token);
        if (idToken != null) {
            IdToken.Payload payload = idToken.getPayload();

            String email = ((GoogleIdToken.Payload) payload).getEmail();
            //boolean emailVerified = ((GoogleIdToken.Payload) payload).getEmailVerified();
            String nimi = (String) payload.get("name");
            String pilt = (String) payload.get("picture");
            String id = payload.getSubject();

            System.out.println(id);

            if (kasutajaRepository.getKasutajaById(id).size() == 0) {
                kasutajaRepository.kasutajaUpdate(nimi, email, pilt, id);
            }


        } else {
            System.out.println("Invalid ID token.");
        }
    }
}
