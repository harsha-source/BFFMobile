package client;

import configuration.FeignConfig;
import models.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "A1", url = "http://internal-bookstore-dev-InternalALB-178925506.us-east-1.elb.amazonaws.com:3000/books", configuration = FeignConfig.class)
public interface BooksClient {
//        @GetMapping
//        Object getAllBooks();

    @PostMapping
    Object addBook(Books book);

    @PutMapping("/{isbn}")
    Object updateBook(@PathVariable("isbn") String isbn, Books book);


    @GetMapping("/{isbn}")
    Object getBookByIsbn(@PathVariable("isbn") String isbn);

    @GetMapping("/isbn/{isbn}")
    Object getBookByIsbnAlt(@PathVariable("isbn") String isbn);

    @GetMapping("/status")
    Object getStatus();
}
