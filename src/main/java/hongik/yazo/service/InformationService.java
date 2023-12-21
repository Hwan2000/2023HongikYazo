package hongik.yazo.service;

import hongik.yazo.domain.Work;
import hongik.yazo.dto.NameAndThumbnailResponse;
import hongik.yazo.dto.ResponseDTO;
import hongik.yazo.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InformationService {

    private final WorkRepository workRepository;

    public ResponseDTO information(int num){
        Optional<Work> byId = workRepository.findById(num);

        ResponseDTO responseDTO = new ResponseDTO();

        if(byId.isPresent()){
            Work work = byId.get();

            responseDTO.setTitle(work.getTitle().replace("\\n", "\n"));
            responseDTO.setSize(work.getSize().replace("\\n", "\n"));
            responseDTO.setIng(work.getIngredient().replace("\\n", "\n"));
            responseDTO.setName(work.getName());
            responseDTO.setText(work.getText().replace("\\n", "\n"));
        }

        return responseDTO;
    }

    public NameAndThumbnailResponse nameAndTitleList() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<Work> findAllWork = workRepository.findAll(sort);

        List<String> titles = findAllWork.stream()
                .map(work -> work.getTitle().replace("\\n", ""))
                .collect(Collectors.toList());

        // 예외 처리
        titles.set(7, "SAR 001/SAR 002/Skelly");

        List<String> names = findAllWork.stream()
                .map(Work::getName)
                .collect(Collectors.toList());

        NameAndThumbnailResponse result = new NameAndThumbnailResponse();

        result.setNameList(names);
        result.setTitleList(titles);

        return result;
    }
}
