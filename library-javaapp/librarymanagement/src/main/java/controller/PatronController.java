package controller;
package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Patron;
import com.example.librarymanagement.service.PatronService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable Long id) {
        return patronService.getPatronById(id).orElse(null);
    }

    @PostMapping
    public Patron addPatron(@RequestBody Patron patron) {
        return patronService.addPatron(patron);
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable Long id, @RequestBody Patron patronDetails) {
        return patronService.updatePatron(id, patronDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
    }
}
