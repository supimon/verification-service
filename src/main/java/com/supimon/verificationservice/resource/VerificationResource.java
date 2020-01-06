package com.supimon.verificationservice.resource;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.supimon.verificationservice.models.VerificationModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/verification")
public class VerificationResource {

    @RequestMapping("/{chefId}")
    public Boolean getVerification(@PathVariable("chefId") String chefId) throws InterruptedException, ExecutionException {

        Firestore db = FirestoreClient.getFirestore();

        CollectionReference chefVer = db.collection("verification");
        // Create a query against the collection.
        Query query = chefVer.whereEqualTo("chefId", chefId);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

        VerificationModel verificationModel = new VerificationModel();

        for (QueryDocumentSnapshot document : documents) {
            verificationModel.setUserId(document.getString("chefId"));
            verificationModel.setVerified(document.getBoolean("verified"));
        }

        return verificationModel.isVerified();
    }
}
