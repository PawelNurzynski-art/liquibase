package com.pawel.liquibase.controller;

import com.pawel.liquibase.dto.PageDto;
import com.pawel.liquibase.entity.PageEntity;
import com.pawel.liquibase.repository.PageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pages")
public class PageController {
    public PageRepository pageRepository;
    public PageDto pageDto;

    // get all pages
    @GetMapping("")
    public List<PageEntity> getAllPages() {
        return pageRepository.findAll();
    }

    // get page by id
    @GetMapping("/{id}")
    public Optional<PageEntity> getPage(@PathVariable("id") UUID id) {
        return pageRepository.findById(id);
    }

    // add page
    @PostMapping("")
    public PageEntity addPage(@RequestBody PageDto pageDto) {
        PageEntity newPage = new PageEntity();

        newPage.setPageNumber(pageDto.getPageNumber());

        pageRepository.save(newPage);
        return newPage;
    }

    // edit page
    @PutMapping("/{id}")
    public PageEntity editPage(@PathVariable("id") UUID id,
                               @RequestBody PageDto pageDto) {

        PageEntity editedPage = pageRepository.getReferenceById(id);

        editedPage.setPageNumber(pageDto.getPageNumber());

        pageRepository.save(editedPage);
        return editedPage;
    }

    // delete page
    @DeleteMapping("/{id}")
    public void deletePage(@PathVariable("id") UUID id) {
        pageRepository.deleteById(id);
    }
}
