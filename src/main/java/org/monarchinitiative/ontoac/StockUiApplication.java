package org.monarchinitiative.ontoac;


import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockUiApplication {

    public static void main(String[] args) {
        Application.launch(OntologyAutocompleteApplication.class, args);
    }

}

