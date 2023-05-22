package com.example.ford.project.dto;

import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LibrarianDto {

    private Integer id;

    @NonNull
    private String first_name;

    @NonNull
    private String last_name;

   @NonNull
   private String email;

   @NonNull
   private String avatar;
}
