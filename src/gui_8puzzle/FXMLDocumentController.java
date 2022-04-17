/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_8puzzle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static jdk.nashorn.internal.objects.NativeRegExp.test;

/**
 *
 * @author Win10
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private Label label_alerta;

    @FXML
    private Button button;

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private ComboBox<String> combo2;

    @FXML
    private ComboBox<String> combo3;

    @FXML
    private ComboBox<String> combo4;

    @FXML
    private ComboBox<String> combo5;

    @FXML
    private ComboBox<String> combo6;

    @FXML
    private ComboBox<String> combo7;

    @FXML
    private ComboBox<String> combo8;

    @FXML
    private ComboBox<String> combo9;

    @FXML
    private Label label_estados;
    @FXML
    private TextField pos1;

    @FXML
    private TextField pos2;

    @FXML
    private TextField pos3;

    @FXML
    private TextField pos4;

    @FXML
    private TextField pos5;

    @FXML
    private TextField pos6;

    @FXML
    private TextField pos7;

    @FXML
    private TextField pos8;

    @FXML
    private TextField pos9;

    List<String> lista = new ArrayList<>();
    ObservableList<String> obsLista;
    int[][] estado_inicial = new int[3][3];
    int valor, nosVisitados;
    Timer timer = new Timer();

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label_estados.setText("Hello World!");
    }

    public void carregaCombo() {
        String[] listaN = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        lista = Arrays.asList(listaN);

        obsLista = FXCollections.observableArrayList(lista);

        combo1.setItems(obsLista);
        combo2.setItems(obsLista);
        combo3.setItems(obsLista);
        combo4.setItems(obsLista);
        combo5.setItems(obsLista);
        combo6.setItems(obsLista);
        combo7.setItems(obsLista);
        combo8.setItems(obsLista);
        combo9.setItems(obsLista);

    }

    public void inicializaMatriz() {
        pos1.setText("0");
        pos2.setText("0");
        pos3.setText("0");
        pos4.setText("0");
        pos5.setText("0");
        pos6.setText("0");
        pos7.setText("0");
        pos8.setText("0");
        pos9.setText("0");

    }

    public void carregaValores() throws Exception {

        try {
            estado_inicial[0][0] = Integer.parseInt(combo1.getSelectionModel().getSelectedItem());
            estado_inicial[0][1] = Integer.parseInt(combo2.getSelectionModel().getSelectedItem());
            estado_inicial[0][2] = Integer.parseInt(combo3.getSelectionModel().getSelectedItem());
            estado_inicial[1][0] = Integer.parseInt(combo4.getSelectionModel().getSelectedItem());
            estado_inicial[1][1] = Integer.parseInt(combo5.getSelectionModel().getSelectedItem());
            estado_inicial[1][2] = Integer.parseInt(combo6.getSelectionModel().getSelectedItem());
            estado_inicial[2][0] = Integer.parseInt(combo7.getSelectionModel().getSelectedItem());
            estado_inicial[2][1] = Integer.parseInt(combo8.getSelectionModel().getSelectedItem());
            estado_inicial[2][2] = Integer.parseInt(combo9.getSelectionModel().getSelectedItem());

            label_alerta.setText("");

            pos1.setText(String.valueOf(estado_inicial[0][0]));
            pos2.setText(String.valueOf(estado_inicial[0][1]));
            pos3.setText(String.valueOf(estado_inicial[0][2]));
            pos4.setText(String.valueOf(estado_inicial[1][0]));
            pos5.setText(String.valueOf(estado_inicial[1][1]));
            pos6.setText(String.valueOf(estado_inicial[1][2]));
            pos7.setText(String.valueOf(estado_inicial[2][0]));
            pos8.setText(String.valueOf(estado_inicial[2][1]));
            pos9.setText(String.valueOf(estado_inicial[2][2]));

        } catch (Exception e) {
            e.getMessage();
            label_alerta.setText("preencha todos os valores !!");
        }

        /* String[] lista = {"7", "1", "5", "0","8", "9", "2", "3", "4", "6"};

        int valor = 500;

        for (String s : lista) {
        valor += 500;
        mudaValor(s, valor);
        }*/
    }

    public void mudaValor(int valor, int[][] estado_inicial) throws InterruptedException {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                pos1.setText(String.valueOf(estado_inicial[0][0]));
                pos2.setText(String.valueOf(estado_inicial[0][1]));
                pos3.setText(String.valueOf(estado_inicial[0][2]));
                pos4.setText(String.valueOf(estado_inicial[1][0]));
                pos5.setText(String.valueOf(estado_inicial[1][1]));
                pos6.setText(String.valueOf(estado_inicial[1][2]));
                pos7.setText(String.valueOf(estado_inicial[2][0]));
                pos8.setText(String.valueOf(estado_inicial[2][1]));
                pos9.setText(String.valueOf(estado_inicial[2][2]));
            }
        }, 1000 + valor);

    }

    public void buscaLargura() throws InterruptedException {
        Noh_arvore no = new Noh_arvore(0, null, estado_inicial, null);
        List<Noh_arvore> solucoes = Problem.buscaLargura(no);

        int valor = 500;

        for (Noh_arvore no2 : solucoes) {
            valor += 500;
            mudaValor(valor, no2.getEstado());
        }
        label_estados.setText("Objetivo alcançado !! \nProfudidade do nó objetivo: " + solucoes.get(solucoes.size() - 1).getProfundidade() + "\n" + "Nós visitados: " + solucoes.size());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
        label_estados.setText("");
        carregaCombo();
        inicializaMatriz();

    }

}
