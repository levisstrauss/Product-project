package com.levisstrauss.project.Service;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageStorageService {

    public String uploadImage(MultipartFile file){
        String fileName = file.getOriginalFilename();  // or generate a unique filename
        Bucket bucket = StorageClient.getInstance().bucket();
        Blob blob;
        try {
            blob = bucket.create(fileName, file.getInputStream(), file.getContentType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return blob.getMediaLink();  // This is the public URL for the uploaded image
    }

}