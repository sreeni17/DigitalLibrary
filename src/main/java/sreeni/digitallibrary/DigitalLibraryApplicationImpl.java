package sreeni.digitallibrary;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class DigitalLibraryApplicationImpl {

    public static void main(String[] args) {
        System.out.println("Hi Digital Library");
        SpringApplication.run(DigitalLibraryApplicationImpl.class, args);
    }

}
