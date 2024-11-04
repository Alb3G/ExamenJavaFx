module org.intro.examen {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.intro.examen to javafx.fxml;
    exports org.intro.examen;
}