package br.com.codenation.biblioteca.services.impl;

import br.com.codenation.biblioteca.exceptions.ResourceNotFoundException;
import br.com.codenation.biblioteca.models.Leitor;
import br.com.codenation.biblioteca.repositories.LeitorRepository;
import br.com.codenation.biblioteca.services.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LeitorServiceImpl implements LeitorService {

    private final LeitorRepository leitorRepository;

    @Autowired
    public LeitorServiceImpl(LeitorRepository leitorRespotiroy) {
        this.leitorRepository = leitorRespotiroy;
    }

    @Transactional
    @Override
    public Leitor save(Leitor leitor) {
        leitor.setIdAsNull();
        return leitorRepository.save(leitor);
    }

    @Override
    public Page<Leitor> findAll(Pageable pageable) {
        return leitorRepository.findAll(pageable);
    }

    @Override
    public Leitor findById(Long id) {
        return leitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leitor nao encontrado"));
    }

    @Transactional
    @Override
    public void update(Long id, Leitor leitor) {
        Leitor leitorPersistido = findById(id);
        leitorPersistido.replace(leitor);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        leitorRepository.deleteById(id);
    }

}
