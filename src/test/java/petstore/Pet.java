//1- Pacote
package petstore;

//2 - Biblioteca

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;

//3 - Classe

public class Pet {
    //3.1 - Atributos
    String uri = "https://petstore.swagger.io/v2/pet"; // endere�o da entidade Pet

    //3.2 - M�todos e Fun��es
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test // Identifica o m�todo ou fun��o como um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        // Sintaxe Guerkin
        // Dado - Quando - Ent�o
        // Given - When - Then

        given() //Dado
                .contentType("application/json") //comum em API REST - antigas era "text/xml"
                .log().all()
                .body(jsonBody)
        .when() //Quando
                .post(uri)
        .then() //Ent�o
                .log().all()
                .statusCode(200)
                .statusCode(200)
                .body("name", is("Dante"))
                .body("status", is("available"))
                .body("category.name", is("Dog"))
                .body("tags.name", contains("STA"))
        ;
    }
    @Test
    public void consultaPet(){
        String petId = "151517111987";

        given()
                .contentType("applcation/json")
                .log().all()
                .when()
                .get(uri + "/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Dante"))
                .body("category.name", is("Dog"))
                .body("status", is("available"))

     ;
        System.out.println("Requisi��o de dados: ");
    }
    @Test
    public void alterarPet() throws IOException {
        String jsonBody = lerJson("db/pet2.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(uri)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Dante"))
                .body("status",is("Unavailable"))


;
    }

}
