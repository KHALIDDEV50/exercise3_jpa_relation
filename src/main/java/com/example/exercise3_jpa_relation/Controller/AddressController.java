package com.example.exercise3_jpa_relation.Controller;

import com.example.exercise3_jpa_relation.API.ApiResponse;
import com.example.exercise3_jpa_relation.DTO.AddressDTO;
import com.example.exercise3_jpa_relation.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    // Get all Address
    @GetMapping("/get")
    public ResponseEntity<?> getAllAddress() {

        return ResponseEntity.status(200)

                .body(addressService.getAllAddress());
    }

    // Add Address
    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDTO addressDTO) {

        addressService.addAddress(addressDTO);

        return ResponseEntity.status(200).body(new ApiResponse("Address Add Successful"));
    }

    // Update Address
    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody @Valid AddressDTO addressDTO) {

        addressService.updateAddress(addressDTO);

        return ResponseEntity.status(200).body(new ApiResponse("Address Update Successful"));
    }

    // Delete Address
    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity<?> deleteAddress(@PathVariable Integer teacherId) {

        addressService.deleteAddress(teacherId);

        return ResponseEntity.status(200).body(new ApiResponse("Address Delete Successful"));
    }
}