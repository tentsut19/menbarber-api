package th.co.infinitait.menbarber.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import th.co.infinitait.menbarber.model.CloudinaryRequest;
import th.co.infinitait.menbarber.model.CloudinaryResponse;
import th.co.infinitait.menbarber.service.CloudinaryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cloudinary/")
@Slf4j
public class IndexController {

    @Autowired
    private CloudinaryService cloudinaryService;

    @PostMapping(value = "/upload", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CloudinaryResponse> upload(@RequestParam("image") MultipartFile file) throws Exception {
        log.info("file : {}",file.getOriginalFilename());
        return ResponseEntity.ok(cloudinaryService.uploadCloudinary(file));
    }

}
