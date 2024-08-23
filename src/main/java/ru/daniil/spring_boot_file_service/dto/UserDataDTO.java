package ru.daniil.spring_boot_file_service.dto;

import lombok.Data;

@Data
public class UserDataDTO {
    private String fileJSON;
    private String title;
    private String creationDate;
    private String description;
}
