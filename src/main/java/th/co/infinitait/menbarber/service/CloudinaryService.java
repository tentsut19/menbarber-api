package th.co.infinitait.menbarber.service;

import com.cloudinary.transformation.Layer;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import th.co.infinitait.menbarber.model.CloudinaryRequest;
import th.co.infinitait.menbarber.model.CloudinaryResponse;
import com.cloudinary.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
public class CloudinaryService {

    @Autowired
    private ObjectMapper objectMapper;

    public CloudinaryResponse uploadCloudinary(MultipartFile file) throws Exception {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dffs5iirz",
                "api_key", "254489826676466",
                "api_secret", "XkOrPaBVHwSx6TOJutYb2OyLUWI"));

//                Map params = ObjectUtils.asMap("public_id", "john_doe_1001");
//
//                Map uploadResult = cloudinary.uploader().upload(file,params);
//                log.info("uploadResult : {}",uploadResult);

//        Map params = ObjectUtils.asMap("use_filename", true);
//        Map uploadResult = cloudinary.uploader().upload(new File("sample.jpg"), params);
//        log.info("uploadResult : {}",uploadResult);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
        formData.add("image", file);
        formData.add("type", "customer");

        String serverUrl = "https://www.tis.in.th/menbarber/api/v1/upload";

        HttpEntity request = new HttpEntity<>(formData, headers);
        RestOperations restTemplate = new RestTemplate();
        ResponseEntity<CloudinaryResponse> response = restTemplate.exchange(serverUrl, HttpMethod.POST, request, CloudinaryResponse.class);
        log.info("response : {}",response);

//        Map uploadResult = cloudinary.uploader().upload("https://firebasestorage.googleapis.com/v0/b/menbarber-1e8c9.appspot.com/o/img%2Fimages.jpg?alt=media&token=6cb5f997-c213-40b6-986e-6a9185fc745b",
//                ObjectUtils.asMap(
//                        "public_id",
//                        "men_hair_fine",
//                        "background_removal",
//                        "cloudinary_ai:fine_edges" ));
//        log.info("uploadResult : {}",uploadResult);

//        String url = cloudinary.url().transformation(new Transformation()
//                .height(375).crop("scale").chain()
//                .underlay(new Layer().publicId("images_1_sewers.jpg")).gravity("south").width(800)).imageTag("men_hair_fine.jpg");
//        log.info(url);
//        CloudinaryResponse responseList = CloudinaryResponse.builder().status(url).build();


        log.info("Body : {}",response.getBody());

        CloudinaryResponse responseList = CloudinaryResponse.builder()
                .code("200")
                .message("Successfully")
                .data("")
                .build();
        return responseList;
    }

}
