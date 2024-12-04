package com.example.mini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.mini.model.Goal;

import com.example.mini.repository.GoalRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class GoalService {
    @Autowired
    private GoalRepository repo;

       public List<Goal> getAll(){
        return repo.findAll();
    }

	public List<Goal> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<Goal> goal = repo.findAll(pageReq);
		return goal.getContent();
	}

    public void save(Goal goal) {
		repo.save(goal);
	}

	public Goal getByIdGoal(Integer idGoal) {
		return repo.findById(idGoal).get();
	}

	public void delete(Integer idGoal) {
		repo.deleteById(idGoal);
	}

	public List<Goal> buscarPorNombre(String nameGoal) {
        return repo.buscarPorNombre(nameGoal);
    }
}
