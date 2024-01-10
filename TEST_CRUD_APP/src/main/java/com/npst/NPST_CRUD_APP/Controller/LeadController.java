package com.npst.NPST_CRUD_APP.Controller;

import com.npst.NPST_CRUD_APP.Entity.Lead;
import com.npst.NPST_CRUD_APP.Exception.LeadAlreadyExistsException;
import com.npst.NPST_CRUD_APP.Messages.ErrorResponseDto;
import com.npst.NPST_CRUD_APP.Messages.ResponseDto;
import com.npst.NPST_CRUD_APP.Service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;
    @PostMapping("/leadRegister")
    public ResponseEntity<ResponseDto> createLead(@Valid @RequestBody Lead lead) {
        try {
            Lead createdLead = leadService.createLead(lead);
            return new ResponseEntity<>(createSuccessResponse("Created Leads Successfully"), HttpStatus.CREATED);
        } catch (LeadAlreadyExistsException e) {
            return new ResponseEntity<>(createErrorResponse("E10010", e.getMessage()), HttpStatus.CONFLICT);
        }
    }
    private ResponseDto createSuccessResponse(String message) {
        return new ResponseDto("success", message);
    }

    private ResponseDto createErrorResponse(String code, String message) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(code, Collections.singletonList(message));
        return new ResponseDto("error", errorResponse);
    }




    @GetMapping("/by-mobile")
    public ResponseEntity<?> getLeadByMobileNumber(@RequestParam String mobileNumber) {
        List<Lead> emplyeeList = leadService.getLeadsByMobileNumber(mobileNumber);

        if (emplyeeList.isEmpty()) {
            List<String> errorMessages = Collections.singletonList("No Lead found with the Mobile Number " + mobileNumber);
            ErrorResponseDto errorResponseDto = new ErrorResponseDto("E10011", errorMessages);
            ResponseDto responseDto = new ResponseDto("error", errorResponseDto);
            return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
        }

        ResponseDto responseDto = new ResponseDto("success", emplyeeList);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }



    @GetMapping("/lead/{id}")
    public ResponseEntity<Lead> get(@PathVariable Long id) {
        try {
            Lead lead = leadService.get(id);
            return new ResponseEntity<Lead>(lead, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Lead>(HttpStatus.NOT_FOUND);
        }
    }


}
