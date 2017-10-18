package pl.examples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.examples.model.Book;
import pl.examples.service.BookRepository;
import pl.examples.service.GenericRepository;

import java.lang.reflect.GenericArrayType;

/**
 * Created by toustym on 17.10.2017.
 */

@Configuration
@ComponentScan
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringAOPApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAOPApplication.class);

        BookRepository repo = ctx.getBean(BookRepository.class);
        repo.add(new Book("1-123-123-123", "Książka pierwsza", "Autor pierwszej książki"));
        repo.add(new Book("2-234-234-234", "Książka druga", "Autor drugiej książki"));
        repo.add(new Book("3-345-345-345", "Książka trzecia", "Autor trzeciej książki"));

        Book bookData = repo.get("3-345-345-345");
        System.out.println(bookData);

        ctx.close();

    }


}
