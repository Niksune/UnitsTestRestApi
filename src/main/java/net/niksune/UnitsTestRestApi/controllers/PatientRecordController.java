package net.niksune.UnitsTestRestApi.controllers;

import net.niksune.UnitsTestRestApi.entities.PatientRecord;
import net.niksune.UnitsTestRestApi.exceptions.InvalidRequestException;
import net.niksune.UnitsTestRestApi.exceptions.NotFoundException;
import net.niksune.UnitsTestRestApi.repositories.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/patient")
public class PatientRecordController {

    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping
    public List<PatientRecord> getAllRecords() {
        System.out.println("GET all");
        return patientRecordRepository.findAll();
    }

    @GetMapping(value = "{patientId}")
    public PatientRecord getPatientById(@PathVariable(value="patientId") Long patientId) {
        System.out.println("GET one");
        return patientRecordRepository.findById(patientId).get();
    }

    @PostMapping
    public PatientRecord createRecord(@RequestBody PatientRecord patientRecord) {
        System.out.println("POST");
        return patientRecordRepository.save(patientRecord);
    }

    @PutMapping
    public PatientRecord updatePatientRecord(@RequestBody PatientRecord patientRecord) throws NotFoundException {
        System.out.println("PUT");
        if (patientRecord == null || patientRecord.getPatientId() == null) {
            throw new InvalidRequestException("PatientRecord or ID must not be null!");
        }
        Optional<PatientRecord> optionalRecord = patientRecordRepository.findById(patientRecord.getPatientId());
        if (optionalRecord.isEmpty()) {
            throw new NotFoundException("Patient with ID " + patientRecord.getPatientId() + " does not exist.");
        }
        PatientRecord existingPatientRecord = optionalRecord.get();

        existingPatientRecord.setName(patientRecord.getName());
        existingPatientRecord.setAge(patientRecord.getAge());
        existingPatientRecord.setAddress(patientRecord.getAddress());

        return patientRecordRepository.save(existingPatientRecord);
    }

    @DeleteMapping(value = "{patientId}")
    public void deletePatientById(@PathVariable(value = "patientId") Long patientId) throws NotFoundException {
        System.out.println("DELETE");
        if (patientRecordRepository.findById(patientId).isEmpty()) {
            throw new NotFoundException("Patient with ID " + patientId + " does not exist.");
        }
        patientRecordRepository.deleteById(patientId);
    }

}
