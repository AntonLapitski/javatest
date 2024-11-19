package com.ifortex.bookservice.service.impl;

import com.ifortex.bookservice.dto.SearchCriteria;
import com.ifortex.bookservice.model.Book;
import com.ifortex.bookservice.service.BookService;
import com.ifortex.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

// Attention! It is FORBIDDEN to make any changes in this file!
@Service
public class ESBookServiceImpl implements BookService {

  @Inject
  private BookRepository bookRepository;

  @Override
  public Map<String, Long> getBooks() {
    return bookRepository.getBooksCountByGenre();
  }

  @Override
  public List<Book> getAllByCriteria(SearchCriteria searchCriteria) {
     if(bookRepository.getBooksByCriteria(searchCriteria)){
       return bookRepository.getBooksByCriteria(searchCriteria);
     } else {
       return bookRepository.getAllBooks();
     }
  }
}
