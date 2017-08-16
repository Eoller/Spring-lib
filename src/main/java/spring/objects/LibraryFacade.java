package spring.objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.dao.interfaces.BookDAO;
import spring.entities.Book;

import java.util.List;

@Component
public class LibraryFacade {


    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        books = bookDAO.getBooks();
    }

    private List<Book> books;


    public List<Book> getBooks() {
        return books;
    }
}
