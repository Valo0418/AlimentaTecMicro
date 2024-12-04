package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.UserPatient;
import com.example.alimentaTec.repository.UserPatientRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserPatientService{
    @Autowired
	private UserPatientRepository repo;

	public List<UserPatient> getAll() {
		return repo.findAll();
	}

	public List<UserPatient> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<UserPatient> userPatient = repo.findAll(pageReq);
		return userPatient.getContent();
	}

	public void save(UserPatient UserPatient) {
		repo.save(UserPatient);
	}

	public UserPatient getByUserPatientId(Integer UserPatientId) {
		return repo.findById(UserPatientId).get();
	}

	public void delete(Integer UserPatientId) {
		repo.deleteById(UserPatientId);
	}

	public List<UserPatient> searchbyUserName(String userName){
    return repo.searchbyUserName(userName);
    }
}

