package com.Testing.CrudOperations1.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Testing.CrudOperations1.Modal.Books;
import com.Testing.CrudOperations1.Repository.BooksRepository;



@Service
public class BookService {
	@Autowired
	BooksRepository booksrepo;
	
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksrepo.findAll().forEach(books1 -> books.add(books1));
		return books;
	}
	
	
	public Books getBooksById(int id) {
		return booksrepo.findById(id).get();
	}
	
	public void save(Books books) {
		booksrepo.save(books);
	}
	public void updatebook(Books books ,int id) {
		List<Books> lc =(List<Books>) booksrepo.findAll();
		for(Books b:lc) {
			if (b.getBookid()==id) {
				b.setBookname(books.getBookname());
				b.setAuthor(books.getAuthor());
				booksrepo.save(books);
			}
		}
	}
	
	public void delete( int id) {
		booksrepo.deleteById(id);
	}
	
	public void update(Books books, int bookid) {
		booksrepo.save(books);
	}
	public List<Books> getdetails(List<Books> bo) {
		 
		 
		 List<Books>l1=bo.stream().filter(x->x.getPrice()==100).collect(Collectors.toList());
		return l1 ;
	}
	public List<Books> getname(List<Books>bn){
		List<Books>l2=bn.stream().filter(x->x.getBookname().startsWith("S")).collect(Collectors.toList());
		return l2;
	}
	public List<Books> getsearch(String name,List<Books> ba ){
		List<Books>l3 =ba.stream().filter(x->x.getBookname().equals(name)).collect(Collectors.toList()); 
		return l3;
		
	}
	
	public List<Books> getsort(int id,List<Books> bc ){
		List<Books>l4 =bc.stream().filter(x->x.getBookid()>=id).collect(Collectors.toList()); 
		return l4;
		
	}
	
	public List<Books> getmap(List<Books> bl){
		List<Books> l5 =bl.stream().map(x->{x.setPrice(x.getPrice()+100);return x;}).collect(Collectors.toList());
		return l5;
	}
	
	
	
	
}
	

