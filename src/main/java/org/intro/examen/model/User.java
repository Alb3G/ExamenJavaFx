package org.intro.examen.model;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author Alberto Guzman Moreno
 *
 * Esta clase representa un usuario con los siguientes atributos:
 * email, plataforma, isAdmin, softwareVersion y stamp.
 * Representaria una entidad si tuviese id.
 */
@Data
@AllArgsConstructor
public class User {
    private String email;
    private String platform;
    private Boolean isAdmin;
    private Integer softwareVersion;
    private String stamp;

    public User() {}
}
