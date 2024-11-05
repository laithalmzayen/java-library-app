package service;

package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Patron;
import com.example.librarymanagement.repository.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {
    private final PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Optional<Patron> getPatronById(Long id) {
        return patronRepository.findById(id);
    }

    public Patron addPatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public Patron updatePatron(Long id, Patron patronDetails) {
        Patron patron = patronRepository.findById(id).orElseThrow();
        patron.setName(patronDetails.getName());
        patron.setContactInfo(patronDetails.getContactInfo());
        return patronRepository.save(patron);
    }

    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
