package Entidades;

import Entidades.Persona;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-20T23:50:31")
@StaticMetamodel(Sexo.class)
public class Sexo_ { 

    public static volatile SingularAttribute<Sexo, String> descripcion;
    public static volatile SingularAttribute<Sexo, BigDecimal> idSexo;
    public static volatile CollectionAttribute<Sexo, Persona> personaCollection;

}