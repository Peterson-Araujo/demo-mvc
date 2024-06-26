package com.mballem.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.curso.boot.dao.FuncionarioDao;
import com.mballem.curso.boot.domain.Funcionario;

@Service @Transactional(readOnly = false)
public class FuncionarioServiceImp implements FuncionarioService {

	@Autowired
	private FuncionarioDao dao;
	
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

}
