package com.supimon.verificationservice.resource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.supimon.verificationservice.models.VerificationModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/verification")
public class VerificationResource {

    @RequestMapping("/{chefId}")
    public boolean getVerification(@PathVariable("chefId") String chefId) throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/chefapp-eeae0-firebase-adminsdk-tujtr-198a71e00a.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://chefapp-eeae0.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);

        return getVerificationDetails(chefId).isVerified();
    }

    private VerificationModel getVerificationDetails(String chefId){
        return new VerificationModel(true, "ADM24");
    }
}
