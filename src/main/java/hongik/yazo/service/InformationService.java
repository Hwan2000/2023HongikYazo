package hongik.yazo.service;

import hongik.yazo.domain.Work;
import hongik.yazo.dto.ResponseDTO;
import hongik.yazo.repository.WorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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
            responseDTO.setSize(work.getSize());
            responseDTO.setIng(work.getIngredient());
            responseDTO.setName(work.getName());
            responseDTO.setText(work.getText().replace("\\n", "\n"));
        }

        return responseDTO;
    }

    public List<String> nameList() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<Work> findAllWork = workRepository.findAll(sort);

        return findAllWork.stream()
                .map(Work::getName)
                .collect(Collectors.toList());
    }
}
