package com.example.ford.project.service;

import com.example.ford.project.dto.LibrarianDto;
import com.example.ford.project.model.AllLibrarianResponse;
import com.example.ford.project.model.Librarian;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ford.project.repository.LibrarianRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Librarian librarian;

    @Autowired
    private AllLibrarianResponse allLibrarianResponse;

    public LibrarianDto saveLibrarianData(LibrarianDto librarianDto)
    {

       librarian= modelMapper.map(librarianDto, Librarian.class);
       librarianRepository.save(librarian);
       return modelMapper.map(librarian,LibrarianDto.class);
    }

    public LibrarianDto getLibrarianData(String emailId)
    {
        librarian =librarianRepository.findByEmail(emailId);

        return modelMapper.map(librarian,LibrarianDto.class);
    }

    public List<LibrarianDto> getAllData() {
        List<Librarian> librarianList=librarianRepository.findAll();
        return librarianList.stream().map(librarian1 -> modelMapper.map(librarian1,LibrarianDto.class)).collect(Collectors.toList());
    }
    public AllLibrarianResponse getAllLibrarianResponse()
    {
        return AllLibrarianResponse.builder().data(getAllData()).build();
    }
}
