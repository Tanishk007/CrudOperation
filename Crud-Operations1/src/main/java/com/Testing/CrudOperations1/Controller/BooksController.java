package com.Testing.CrudOperations1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Testing.CrudOperations1.Modal.Books;
import com.Testing.CrudOperations1.Repository.BooksRepository;
import com.Testing.CrudOperations1.Service.BookService;



@RestController
public class BooksController {
	@Autowired
	BookService bookser;
	@Autowired
	BooksRepository bookrepo;
	
	@GetMapping("/book")
	List<Books> getAllBooks ()
	{
		return bookser.getAllBooks();
	}
	@GetMapping("/getnamess/{name}")
	List<Books> getnamess(@PathVariable String name){
		return  bookrepo.getnamess(name);
		
	}
	@GetMapping("/getids/{id}")
	List<Books>getids(@PathVariable int id){
		return bookrepo.getids(id);
	}
	@GetMapping("/getbookprice/{price}")
	List<Books>getbookprice(@PathVariable int price){
		return bookrepo.getbookprice(price);
	}
	
	@GetMapping("/book/{bookid}")
	Books getBooks(@PathVariable("bookid")int bookid) {
		return bookser.getBooksById(bookid);
		
		
	}
	@GetMapping("/getdetails")
	List<Books> getdetails(){
		return bookser.getdetails(bookser.getAllBooks());
	}
	
	@GetMapping("/getname")
	List<Books> getname(){
		return bookser.getname(bookser.getAllBooks());
	}
	@GetMapping("/getsearch/{Bookname}")
	List<Books> getsearch(@PathVariable String Bookname){
		return bookser.getsearch(Bookname, getAllBooks());
	}
	
	@GetMapping("/getsort/{Bookid}")
	List<Books> getsort(@PathVariable int Bookid){
		return bookser.getsort(Bookid, getAllBooks());
	}
	
	@DeleteMapping("/book/{bookid}")
	public String deleteBook(@PathVariable("bookid")int bookid) {
		bookser.delete(bookid);
		return "Delete sucessfully";
	}
	
	@PostMapping("/books1")
	String saveBook(@RequestBody Books books) {
		bookser.save(books);
		return books.getBookname();
	}
	
	@PutMapping("/booksupdate/{id}")
	Books update(@PathVariable int id, @RequestBody Books books) {
		
		bookser.updatebook(books,id);
		
		return books;
	}
	
	@GetMapping("/getmap")
	List<Books> getmap(){
		
		return bookser.getmap(getAllBooks());
	}
	

}