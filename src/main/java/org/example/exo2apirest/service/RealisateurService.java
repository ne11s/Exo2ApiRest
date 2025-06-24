package org.example.exo2apirest.service;


import org.example.exo2apirest.dto.RealisateurReceiveDto;
import org.example.exo2apirest.dto.RealisateurResponseDto;
import org.example.exo2apirest.entity.Realisateur;
import org.example.exo2apirest.exeception.NotFoundException;
import org.example.exo2apirest.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {

    private final RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    public RealisateurResponseDto create (RealisateurReceiveDto realisateurReceiveDto){
        return realisateurRepository.save(realisateurReceiveDto.dtoToEntity()).entityToDto();
    }

    public RealisateurResponseDto get(long id){
        return realisateurRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<RealisateurResponseDto> get(){
        return realisateurRepository.findAll().stream().map(Realisateur::entityToDto).toList();
    }

    public RealisateurResponseDto update(long id,RealisateurReceiveDto realisateurReceiveDto){
        Realisateur RealisateurFound = realisateurRepository.findById(id).orElseThrow(NotFoundException::new);
        Realisateur RealisateurGet = realisateurReceiveDto.dtoToEntity();
        RealisateurFound.setFirst_name(RealisateurGet.getFirst_name());
        RealisateurFound.setLast_name(RealisateurGet.getLast_name());
        RealisateurFound.setBirthDate(RealisateurGet.getBirthDate());
        RealisateurFound.setNationality(RealisateurGet.getNationality());
        return realisateurRepository.save(RealisateurFound).entityToDto();
    }

    public void delete (long id){
        realisateurRepository.deleteById(id);
    }
}
