package ru.daniil.spring_boot_file_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/file-manager")
public class UserDataController {
    private final UserDataService userDataService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody UserDataDTO dto){
        return new ResponseEntity<>(userDataService.create(dto), HttpStatus.OK);
    }
    
    
    @GetMapping
    public ResponseEntity<List<UserData>> readAll(){
        return new ResponseEntity<>(userDataService.readAll(), HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<UserData> find(@PathVariable Long id){
        return new ResponseEntity<>(userDataService.find(id), HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<List<UserData>> pagingAndSortingData(
        @RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset, 
    @RequestParam(value = "limit", defaultValue = "5") @Min(1) @Max(100) Integer limit){
        return new ResponseEntity<>(userDataService.pagingAndSortingData(limit, offset), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        userDataService.delete(id);
        return HttpStatus.OK;
    }

}