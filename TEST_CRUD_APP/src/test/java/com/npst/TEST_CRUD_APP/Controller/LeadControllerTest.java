package com.npst.TEST_CRUD_APP.Controller;

import com.npst.TEST_CRUD_APP.Entity.Lead;
import com.npst.TEST_CRUD_APP.Exception.LeadAlreadyExistsException;
import com.npst.TEST_CRUD_APP.Messages.ResponseDto;
import com.npst.TEST_CRUD_APP.Service.LeadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class LeadControllerTest {

    @Mock
    private LeadService leadService;

    @InjectMocks
    private LeadController leadController;

    @Test
    public void testCreateLead_Success() {
        Lead lead = createSampleLead();
        when(leadService.createLead(lead)).thenReturn(lead);

        ResponseEntity<ResponseDto> response = leadController.createLead(lead);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("success", response.getBody().getStatus());
        assertEquals(lead, response.getBody().getData());
    }

    @Test
    public void testCreateLead_LeadAlreadyExists() {
        Lead lead = createSampleLead();
        when(leadService.createLead(lead)).thenThrow(new LeadAlreadyExistsException("Lead Already Exists"));

        ResponseEntity<ResponseDto> response = leadController.createLead(lead);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("error", response.getBody().getStatus());
        assertEquals("Lead Already Exists", response.getBody().getData());
    }

    private Lead createSampleLead() {
        Lead lead = new Lead();
        lead.setLeadId(1L);
        lead.setFirstName("Harish");
        lead.setLastName("Bharti");
        lead.setMobileNumber("9876543210");
        lead.setGender("Male");
        lead.setDob("1998-01-01");
        lead.setEmail("harish@example.com");
        return lead;

    }

    @Test
    public void testGetLeadsByMobileNumber_Success() {
        String mobileNumber = "9876543210";
        List<Lead> leads = Arrays.asList(createSampleLead());

        Mockito.when(leadService.getLeadsByMobileNumber(mobileNumber)).thenReturn(leads);

        ResponseEntity<ResponseDto> response = leadController.getLeadsByMobileNumber(mobileNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", response.getBody().getStatus());
        assertEquals(leads, response.getBody().getData());
    }

    @Test
    public void testGetLeadsByMobileNumber_NoLeadsFound() {
        String mobileNumber = "9876543210";
        List<Lead> leads = Collections.emptyList();

        Mockito.when(leadService.getLeadsByMobileNumber(mobileNumber)).thenReturn(leads);

        ResponseEntity<ResponseDto> response = leadController.getLeadsByMobileNumber(mobileNumber);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("success", response.getBody().getStatus());
        assertEquals("No leads found with the mobile number.", response.getBody().getData());
    }

    @Test
    public void testGetLeadsByMobileNumber_InternalServerError() {
        String mobileNumber = "9876543210";

        Mockito.when(leadService.getLeadsByMobileNumber(mobileNumber)).thenThrow(new RuntimeException("Internal Server Error"));

        ResponseEntity<ResponseDto> response = leadController.getLeadsByMobileNumber(mobileNumber);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("error", response.getBody().getStatus());
        assertEquals("Internal Server Error", response.getBody().getData());
    }
}
