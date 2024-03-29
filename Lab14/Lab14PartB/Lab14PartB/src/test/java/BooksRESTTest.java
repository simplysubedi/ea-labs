import books.domain.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneBook() {
        // add the book to be fetched
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("878"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(18.95f))
                .body("author", equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testGetAllBooks() {
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("books").then()
                .statusCode(200);
        given()
                .when()
                .get("books")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("books", hasSize(1));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testAddNewBook() {
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("books").then()
                .statusCode(200);
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("878"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(18.95f))
                .body("author", equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testUpdateABook() {
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        Book updatedBook = new Book("878", "Book 1234", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("books").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(updatedBook)
                .when().put("books/" + updatedBook.getIsbn()).then()
                .statusCode(200);
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("878"))
                .body("title", equalTo("Book 1234"))
                .body("price", equalTo(18.95f))
                .body("author", equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testDeleteABook() {
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("books").then()
                .statusCode(200);
        given()
                .when()
                .delete("books/878");
        given()
                .when()
                .get("books/878")
                .then()
                .statusCode(404)
                .and()
                .body("errorMessage", equalTo("Book with isbn= 878 is not available"));
    }

}
