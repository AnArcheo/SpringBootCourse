package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repositories.IBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

//spring MVC Controller
@Controller
public class BookController {

    private final IBookRepository bookRepository;

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
         return "books/list";
    }

    public BookController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
