package hongik.yazo.service;

import hongik.yazo.domain.Photo;
import hongik.yazo.domain.Work;
import hongik.yazo.dto.ResponseDTO;
import hongik.yazo.repository.PhotoRepository;
import hongik.yazo.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InformationService {

    private final WorkRepository workRepository;
    private final PhotoRepository photoRepository;

    public ResponseDTO information(int num){
        Optional<Work> byId = workRepository.findById(num);

        ResponseDTO responseDTO = new ResponseDTO();

        if(byId.isPresent()){
            Work work = byId.get();

            responseDTO.setTitle(work.getTitle().replace("\\n", "\n"));
            responseDTO.setSize(work.getSize());
            responseDTO.setIng(work.getIngredient());
            responseDTO.setName(work.getName());
            responseDTO.setText(work.getText().replace("\\n", "\n"));
        }

        return responseDTO;
    }
}
