package com.npst.TEST_CRUD_APP.Service;

import com.npst.TEST_CRUD_APP.Entity.Lead;
import com.npst.TEST_CRUD_APP.Exception.LeadAlreadyExistsException;
import com.npst.TEST_CRUD_APP.Repository.LeadRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class LeadServiceTest {

    @Mock
    private LeadRepository leadRepository;

    @InjectMocks
    private LeadService leadService;

    @Test
    public void testCreateLead_Success() {
        Lead lead = createSampleLead();
        when(leadRepository.findById(lead.getLeadId())).thenReturn(Optional.empty());
        when(leadRepository.save(lead)).thenReturn(lead);

        Lead result = leadService.createLead(lead);

        assertEquals(lead, result);
    }

    @Test(expected = LeadAlreadyExistsException.class)
    public void testCreateLead_LeadAlreadyExists() {
        Lead lead = createSampleLead();
        when(leadRepository.findById(lead.getLeadId())).thenReturn(Optional.of(lead));

        leadService.createLead(lead);
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
}