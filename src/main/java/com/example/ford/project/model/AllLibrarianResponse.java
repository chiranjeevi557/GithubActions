package com.example.ford.project.model;

import com.example.ford.project.dto.LibrarianDto;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder
public class AllLibrarianResponse {
    public List<LibrarianDto> data;

}
