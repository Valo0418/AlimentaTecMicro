package com.example.alimentaTec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.alimentaTec.model.Login;
import com.example.alimentaTec.repository.LoginRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginRepository repo;

	public List<Login> getAll() {
		return repo.findAll();
	}

	public void save(Login login) {
		repo.save(login);
	}

	public Login getByIdLogin(Integer idUser) {
		return repo.findById(idUser).get();
	}

	public void delete(Integer idUser) {
		repo.deleteById(idUser);
	}

    public Login getByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByUsername'");
    }

}
