package com.db.DarkMode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDTO {
    private boolean DarkModeON;
    private List<CarDTO> cars;
}
