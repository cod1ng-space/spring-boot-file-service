package ru.daniil.spring_boot_file_service.service;

import org.springframework.stereotype.Service;
import java.util.List;
import lombok.AllArgsConstructor;
import ru.daniil.spring_boot_file_service.dto.UserDataDTO;
import ru.daniil.spring_boot_file_service.entity.UserData;
import ru.daniil.spring_boot_file_service.repository.UserDataRepository;

@Service
@AllArgsConstructor
public class UserDataService{
    private final UserDataRepository userDataRepository;

    public Long create(UserDataDTO dto){
        UserData userData = UserData.builder()
        .fileJSON(dto.getFileJSON())
        .title(dto.getTitle())
        .creationDate(dto.getCreationDate())
        .description(dto.getDescription())
        .build();
        return userDataRepository.save(userData).getId();
    }

    public List<UserData> readAll(){
        return userDataRepository.findAll();
    }
    
    public UserData find(Long id){
        return userDataRepository.findById(id).orElse(null);
    }
}