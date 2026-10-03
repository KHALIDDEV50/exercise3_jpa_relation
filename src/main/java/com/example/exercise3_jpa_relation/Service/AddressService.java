package com.example.exercise3_jpa_relation.Service;

import com.example.exercise3_jpa_relation.API.ApiException;
import com.example.exercise3_jpa_relation.DTO.AddressDTO;
import com.example.exercise3_jpa_relation.Model.Address;
import com.example.exercise3_jpa_relation.Model.Teacher;
import com.example.exercise3_jpa_relation.Repository.AddressRepository;
import com.example.exercise3_jpa_relation.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    // Get all Address
    public List<Address> getAllAddress() {

        return addressRepository.findAll();
    }

    // Add Teacher Address
    public void addAddress(AddressDTO addressDTO) {

        Teacher teacher = teacherRepository.findById(addressDTO.getTeacherId()).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        if (teacher.getAddress() != null) {
            throw new ApiException("Teacher already has an address");
        }

        Address address = new Address();

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        // Connect Address with Teacher
        address.setTeacher(teacher);

        addressRepository.save(address);
    }

    // Update Teacher Address
    public void updateAddress(AddressDTO addressDTO) {

        Teacher teacher = teacherRepository.findById(addressDTO.getTeacherId()).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Address address = teacher.getAddress();

        if (address == null) {
            throw new ApiException("Address not found");
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    // Delete Teacher Address
    public void deleteAddress(Integer teacherId) {

        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);

        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }

        Address address = teacher.getAddress();

        if (address == null) {
            throw new ApiException("Address not found");
        }

        addressRepository.delete(address);
    }
}