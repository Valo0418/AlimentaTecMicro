package com.example.mini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.mini.model.PhysicalActivity;
import com.example.mini.repository.PhysicalActivityRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PhysicalActivityService {
    @Autowired
    private PhysicalActivityRepository repo;

     public List<PhysicalActivity> getAll(){
        return repo.findAll();
    }

	public List<PhysicalActivity> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<PhysicalActivity> physicalActivity = repo.findAll(pageReq);
		return physicalActivity.getContent();
	}

    public void save(PhysicalActivity physicalActivity) {
		repo.save(physicalActivity);
	}

	public PhysicalActivity getByIdActivity(Integer idActivity) {
		return repo.findById(idActivity).get();
	}

	public void delete(Integer idActivity) {
		repo.deleteById(idActivity);
	}
}