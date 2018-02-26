package com.jk.asset.controller;

import com.jk.asset.model.DocumentDTO;
import com.jk.asset.service.DocumentService;
import com.powerbroker.common.handler.AbstractCRUDHandler;
import com.powerbroker.common.handler.ControllerTemplate;
import com.powerbroker.common.handler.GenericResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

/**
 * @author william
 */
@RestController
@RequestMapping(value = "/document")
public class DocumentController extends AbstractCRUDHandler<Long, DocumentDTO, DocumentService> {

    @PostMapping("/upload")
    public GenericResponse<DocumentDTO> upload(@RequestParam("file") MultipartFile request) throws Exception {

        return ControllerTemplate.call((GenericResponse<DocumentDTO> response) -> {

            DocumentDTO documentDTO = getService().upload(Arrays.asList(request));
            response.setData(getService().create(documentDTO));
            response.setResult(true);
        });
    }

    // TODO:http://stackoverflow.com/questions/41083751/upload-and-display-images-using-thymeleaf-and-springboot
//    @GetMapping(value = "image/{imageName}")
//    @ResponseBody
//    public byte[] getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
//
//        File serverFile = new File("/home/user/uploads/" + imageName + ".jpg");
//
//        return Files.readAllBytes(serverFile.toPath());
//    }

//    public ResponseEntity<?> uploadFile(
//            @RequestParam("file") MultipartFile uploadfile) {
//
//        log.debug("Single file upload!");
//
//        if (uploadfile.isEmpty()) {
//            return new ResponseEntity("please select a file!", HttpStatus.OK);
//        }
//
//        try {
//
//            saveUploadedFiles(Arrays.asList(uploadfile));
//
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity("Successfully uploaded - " +
//                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
//
//    }

//    // 3.1.2 Multiple file upload
//    @PostMapping("/api/upload/multi")
//    public ResponseEntity<?> uploadFileMulti(
//            @RequestParam("extraField") String extraField,
//            @RequestParam("files") MultipartFile[] uploadfiles) {
//
//        log.debug("Multiple file upload!");
//
//        // Get file name
//        String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
//                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
//
//        if (StringUtils.isEmpty(uploadedFileName)) {
//            return new ResponseEntity("please select a file!", HttpStatus.OK);
//        }
//
//        try {
//
//            saveUploadedFiles(Arrays.asList(uploadfiles));
//
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity("Successfully uploaded - "
//                + uploadedFileName, HttpStatus.OK);
//
//    }
//
//    // 3.1.3 maps html form to a Model
//    @PostMapping("/api/upload/multi/model")
//    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadModel model) {
//
//        log.debug("Multiple file upload! With UploadModel");
//
//        try {
//
//            saveUploadedFiles(Arrays.asList(model.getFiles()));
//
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity("Successfully uploaded!", HttpStatus.OK);
//
//    }

//    //save file
//    private void saveUploadedFiles(List<MultipartFile> files) {
//
//        for (MultipartFile file : files) {
//
//            if (file.isEmpty()) {
//                continue; //next pls
//            }
//            try {
//                byte[] bytes = file.getBytes();
//                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//                Files.write(path, bytes);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }

}
