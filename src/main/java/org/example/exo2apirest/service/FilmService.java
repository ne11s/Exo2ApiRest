package org.example.exo2apirest.service;

import org.example.exo2apirest.dto.FilmReceiveDto;
import org.example.exo2apirest.dto.FilmResponseDto;
import org.example.exo2apirest.dto.FilmReceiveDto;
import org.example.exo2apirest.dto.FilmResponseDto;
import org.example.exo2apirest.entity.Film;
import org.example.exo2apirest.exeception.NotFoundException;
import org.example.exo2apirest.repository.FilmRepository;
import org.example.exo2apirest.repository.FilmRepository;
import org.example.exo2apirest.repository.RealisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilmService {
    private final FilmRepository filmRepository;
    public FilmService(FilmRepository filmRepository, RealisateurRepository realisateurRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmResponseDto create (FilmReceiveDto filmReceiveDto){
        return filmRepository.save(filmReceiveDto.dtoToEntity()).entityToDto();
    }

    public FilmResponseDto get(long id){
        return filmRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<FilmResponseDto> get(){
        return filmRepository.findAll().stream().map(Film::entityToDto).toList();
    }

    public FilmResponseDto update(long id,FilmReceiveDto filmReceiveDto){
        Film filmFound = filmRepository.findById(id).orElseThrow(NotFoundException::new);
        Film filmGet = filmReceiveDto.dtoToEntity();
        filmFound.setName(filmGet.getName());
        filmFound.setDescription(filmGet.getDescription());
        filmFound.setGenre(filmGet.getGenre());
        filmFound.setReleaseDate(filmGet.getReleaseDate());
        filmFound.setDuration(filmGet.getDuration());
        filmFound.setRealisateur(filmGet.getRealisateur());
        return filmRepository.save(filmFound).entityToDto();
    }

    public void delete (long id){
        filmRepository.deleteById(id);
    }
}
