package com.oogie.comicrest.controller;

import com.oogie.comicrest.ComicListRepository;
import com.oogie.comicrest.model.ComiclistEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComicController {
    private final ComicListRepository repository;

    ComicController(ComicListRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/comiclist")
    List<ComiclistEntity> all() {
        return repository.findAll();
    }

    @PostMapping("/comiclist")
    ComiclistEntity newComicList(@RequestBody ComiclistEntity nuComicList) {
        return repository.save(nuComicList);
    }

    // Single Item

    @GetMapping("/comiclist/{id}")
    ComiclistEntity one(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ComicNotFoundException(id));
    }

    @PutMapping("/comiclist/{id}")
    ComiclistEntity replaceComiclist(@RequestBody ComiclistEntity nuComiclist, @PathVariable Integer id) {
        return repository.findById(id).map(comicList -> {
            comicList.setComicname(nuComiclist.getComicname());
            comicList.setIssue(nuComiclist.getIssue());
            comicList.setWriter(nuComiclist.getWriter());
            comicList.setArtist(nuComiclist.getArtist());
            comicList.setPublisher(nuComiclist.getPublisher());
            comicList.setYear(nuComiclist.getYear());
            comicList.setGenre(nuComiclist.getGenre());
            return repository.save(comicList);
        }).orElseGet(() -> {
            nuComiclist.setId(id);
            return repository.save(nuComiclist);
        });
    }

    @DeleteMapping("/comiclist/{id}")
    void deleteCredentials(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
