package com.levisstrauss.project.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Configuration
public class FirebaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseConfig.class);

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void initialize() {
        try {
            initializeFirebase();
        } catch (IOException e) {
            logger.error("Failed to initialize Firebase: {}", e.getMessage());
            // Consider rethrowing the exception if Firebase is critical.
            // throw new RuntimeException("Failed to initialize Firebase", e);
        }
    }

    private void initializeFirebase() throws IOException {
        String firebaseConfigResourcePath = "classpath:com/levisstrauss/project/Configuration/images-fc076-firebase-adminsdk-f4c4a-ce554bebaa.json";
        Resource resource = resourceLoader.getResource(firebaseConfigResourcePath);

        // Extracting bucket name from the filename. This assumes a certain naming convention. Adjust if different.
        String bucketName = "images/" + Objects.requireNonNull(resource.getFilename()).split("-firebase-adminsdk-")[0] + ".appspot.com";

        try (InputStream inputStream = resource.getInputStream()) {
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(inputStream))
                    .setStorageBucket(bucketName)
                    .build();
            FirebaseApp.initializeApp(options);
        }
    }
}
