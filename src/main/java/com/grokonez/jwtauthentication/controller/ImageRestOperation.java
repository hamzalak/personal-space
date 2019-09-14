package com.grokonez.jwtauthentication.controller;




/*import com.javasampleapproach.uploadfiles.entities.FileInfo;
import com.javasampleapproach.uploadfiles.storage.StorageService; */

import com.grokonez.jwtauthentication.model.ImagePath;
import com.grokonez.jwtauthentication.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;


@CrossOrigin({"*"})
@Controller
public class ImageRestOperation {

    @Autowired
    StorageService storageService;

    private String file ;

    @PostMapping("/post")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);
            this.file = file.getOriginalFilename() ;

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/getImage")
    public ResponseEntity<ImagePath> getListFiles(@PathVariable String nameFile) {
        String fileName =  MvcUriComponentsBuilder
                .fromMethodName(ImageRestOperation.class, "getFile", this.file).build().toString() ;

        return new ResponseEntity<>(new ImagePath(fileName),HttpStatus.OK);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {

        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")

                .body(file);
    }
}

