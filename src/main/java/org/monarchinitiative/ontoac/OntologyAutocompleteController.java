package org.monarchinitiative.ontoac;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.stage.FileChooser;
import net.rgielen.fxweaver.core.FxmlView;
import org.monarchinitiative.phenol.io.OntologyLoader;
import org.monarchinitiative.phenol.ontology.data.Ontology;
import org.monarchinitiative.phenol.ontology.data.TermId;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Optional;


@Component
@FxmlView("/chart.fxml")
public class OntologyAutocompleteController {

    @FXML
    public AutoCompleteOntologyTextField ontologyAutocomplete;

    public OntologyAutocompleteController() {

    }

    @FXML
    public void initialize() {

    }

    @FXML
    public void loadHpo(ActionEvent e) {
        System.out.println("Load HPO");
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("JSON ontology files (*.json)", "*.json");
        //chooser.getExtensionFilters().add(extFilter);
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = chooser.showOpenDialog(null);
        if (file == null) {
            System.err.println("[ERROR] Could not get ontology json file for opening");
            return;
        }
        Ontology ontology = OntologyLoader.loadOntology(file);
        ontologyAutocomplete.setOntology(ontology);

    }

    @FXML
    public void showTermInfo(ActionEvent e) {
        Optional<TermId> opt = ontologyAutocomplete. getSelectedId();
        System.out.printf("Able to get term id: %s\n", opt.isPresent());
        if (opt.isPresent()) {
            System.out.printf("Autocompleted Term id: %s\n", opt.get());
        } else {
            System.out.printf("Unable to get term id: ");
        }
    }
}
