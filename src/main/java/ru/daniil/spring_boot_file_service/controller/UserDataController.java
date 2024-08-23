package ru.daniil.spring_boot_file_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.AllArgsConstructor;
import ru.daniil.spring_boot_file_service.dto.UserDataDTO;
import ru.daniil.spring_boot_file_service.entity.UserData;
import ru.daniil.spring_boot_file_service.service.UserDataService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserDataController {
    private final UserDataService userDataService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody UserDataDTO dto){
        return new ResponseEntity<>(userDataService.create(dto), HttpStatus.OK);
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<UserData> readAll(@PathVariable Long id){
        return new ResponseEntity<>(userDataService.find(id), HttpStatus.OK);
    }
     */
    @GetMapping
    public ResponseEntity<UserData> find(){
        return new ResponseEntity<>(userDataService.find(0l), HttpStatus.OK);
    }
    
}