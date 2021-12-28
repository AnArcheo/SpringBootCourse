package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.IAuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AuthorController {

    private final IAuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }

    public AuthorController(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
