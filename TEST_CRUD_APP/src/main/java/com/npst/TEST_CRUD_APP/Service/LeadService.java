package com.npst.TEST_CRUD_APP.Service;

import com.npst.TEST_CRUD_APP.Entity.Lead;
import com.npst.TEST_CRUD_APP.Exception.LeadAlreadyExistsException;
import com.npst.TEST_CRUD_APP.Repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.List;

@Validated
@Service
@Transactional
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public Lead createLead(Lead lead) {

        if (lead.getLeadId() != null && leadRepository.findById(lead.getLeadId()).isPresent()) {
            throw new LeadAlreadyExistsException("Lead Already Exists in the database with the lead id: " + lead.getLeadId());
        }
        return leadRepository.save(lead);
    }

    public List<Lead> getLeadsByMobileNumber(String mobileNumber) {
        return leadRepository.findByMobileNumber(mobileNumber);
    }


    public Lead get(Long id) {
        return leadRepository.findById(id).get();
    }

}
