package spring.objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.dao.interfaces.BookDAO;
import spring.entities.Author;
import spring.entities.Book;

import java.util.List;

@Component
public class LibraryFacade {

    private static final String FIELD_CONTENT = "content";
    private BookDAO bookDAO;
    @Autowired
    private SearchCriteria searchCriteria;
    private List<Book> books;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        books = bookDAO.getBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void searchBooksByLetter() {
        books = bookDAO.getBooks(searchCriteria.getLetter());
    }

    public void searchBooksByGenre() {
        books = bookDAO.getBooks(searchCriteria.getGenre());
    }

    public void searchBooksByText() {

        switch (searchCriteria.getSearchType()) {
            case TITLE:
                books = bookDAO.getBooks(searchCriteria.getText());
                break;
            case AUTHOR:
                books = bookDAO.getBooks(new Author(searchCriteria.getText()));
                break;
        }
    }

    public byte[] getContent(long id){
        return (byte[])bookDAO.getFieldValue(id, FIELD_CONTENT);
    }

}