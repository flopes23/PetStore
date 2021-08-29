package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class Data {
    // funcao para ler um json
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // funcao para ler csv
    public Collection<String[]> lerCsv(String caminhoCsv){

        return null;

    }
}
