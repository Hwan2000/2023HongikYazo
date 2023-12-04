package hongik.yazo.controller;

import hongik.yazo.dto.ResponseDTO;
import hongik.yazo.service.InformationService;
import hongik.yazo.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InformationController {

    private final InformationService informationService;
    private final PhotoService photoService;

    @GetMapping("/getInfo/{num}")
    public ResponseEntity<ResponseDTO> getInfo(@PathVariable("num") int num){

        if(num > 0 && num < 31){
            ResponseDTO information = informationService.information(num);
            information.setPhotoList(photoService.photoList(num));

            return ResponseEntity.ok(information);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
