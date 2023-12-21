package hongik.yazo.controller;

import hongik.yazo.dto.NameAndThumbnailResponse;
import hongik.yazo.dto.ResponseDTO;
import hongik.yazo.service.InformationService;
import hongik.yazo.service.MovieService;
import hongik.yazo.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class InformationController {

    private final InformationService informationService;
    private final PhotoService photoService;
    private final MovieService movieService;

    @GetMapping("/getInfo/{num}")
    public ResponseEntity<ResponseDTO> getInfo(@PathVariable("num") int num){

        if(num > 0 && num < 31){
            ResponseDTO information = informationService.information(num);
            information.setPhotoList(photoService.photoList(num));
            information.setMovieList(movieService.movieList(num));

            return ResponseEntity.ok(information);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nameAndThumbnail")
    public ResponseEntity<NameAndThumbnailResponse> nameAndThumbnail(){
        NameAndThumbnailResponse nameAndTitleList = informationService.nameAndTitleList();
        List<String> thumbnailList = photoService.thumbnailList();

        NameAndThumbnailResponse response = new NameAndThumbnailResponse();
        response.setTitleList(nameAndTitleList.getTitleList());
        response.setNameList(nameAndTitleList.getNameList());
        response.setThumbnailList(thumbnailList);

        return ResponseEntity.ok(response);
    }
}
