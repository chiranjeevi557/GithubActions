package com.example.ford.project.controller;

import com.example.ford.project.dto.LibrarianDto;
import com.example.ford.project.model.AllLibrarianResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ford.project.service.LibrarianService;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/librarian")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;



    @PostMapping(name = "Adding librarian",value = "/v1",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibrarianDto> addLibrarian(@Valid @RequestBody LibrarianDto librarianDto){
       //log.info("librarian backed service getting the request with name={},emailId={},number={}",librarianDto.getName(),librarianDto.getEmailId(),librarianDto.getName());
       return new ResponseEntity<>(librarianService.saveLibrarianData(librarianDto), HttpStatus.CREATED);
    }
    @GetMapping("/alldata")
    public ResponseEntity<AllLibrarianResponse> getData(){

        return new ResponseEntity<>(librarianService.getAllLibrarianResponse(), HttpStatus.OK);
    }

    @GetMapping(name = "getting librarian", value = "/{emailid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibrarianDto> getLibrarian(@PathVariable String emailid){
        log.info("librarian backed service getting the request with emailId={}",emailid);
        return new ResponseEntity<>(librarianService.getLibrarianData(emailid), HttpStatus.OK);
    }


}
