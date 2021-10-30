package com.example.phone.controllers;

import com.example.phone.PhoneRepository;
import com.example.phone.models.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/phone")
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping
    public List<Phone> listAll() {
        return phoneRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> findPhoneById(@PathVariable(value = "id") Long id) {
        Optional<Phone> phone = phoneRepository.findById(id);
        if (phone.isPresent()) {
            return ResponseEntity.ok().body(phone.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void add(@RequestBody Phone phone) {
        phoneRepository.save(phone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> updatePhone(@PathVariable Long id, @RequestBody Phone phone) {
        Optional<Phone> phoneOptional = phoneRepository.findById(id);
        return phoneOptional.map(phone1 -> {
            phone.setId(phone1.getId());
            return new ResponseEntity<>(phoneRepository.save(phone), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePhone(@PathVariable Long id) {
        try {
            Optional<Phone> phone = phoneRepository.findById(id);
            if (phone.isPresent()) {
                phoneRepository.delete(phone.get());
            }
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
