module org.intro.examen {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens org.intro.examen.model;
    opens org.intro.examen to javafx.fxml;
    exports org.intro.examen;
    exports org.intro.examen.controllers;
    opens org.intro.examen.controllers to javafx.fxml;
}