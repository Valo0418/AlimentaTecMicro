package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.alimentaTec.model.Saucer;
import com.example.alimentaTec.repository.SaucerRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SaucerService {


	@Autowired
	private SaucerRepository repo;

	public List<Saucer> getAll() {
		return repo.findAll();
	}

	public List<Saucer> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Saucer> saucer = repo.findAll(pageReq);
		return saucer.getContent();
	}

	public void save(Saucer saucer) {
		repo.save(saucer);
	}

	public Saucer getByIdSaucer(Integer idSaucer) {
		return repo.findById(idSaucer).get();
	}

	public void delete(Integer idSaucer) {
		repo.deleteById(idSaucer);
	}
	public List<Saucer> searchbyName(String nameSaucer) {
		return repo.searchbyName(nameSaucer);
	}
}