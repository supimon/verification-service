package com.supimon.verificationservice.resource;

import com.supimon.verificationservice.models.VerificationModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verification")
public class VerificationResource {

    @RequestMapping("/{chefId}")
    public boolean getVerification(@PathVariable("chefId") String chefId){
        return getVerificationDetails(chefId).isVerified();
    }

    private VerificationModel getVerificationDetails(String chefId){
        return new VerificationModel(true, "ADM24");
    }
}
