package pl.bykowski.transactionalpolygon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalPolygonApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalPolygonApplication.class, args);
    }

    // DirtyRead -> column
    // NonRepeatableRead -> row
    // PhantomRead -> range of rows
}
