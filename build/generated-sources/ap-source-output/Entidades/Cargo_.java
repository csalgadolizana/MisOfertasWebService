package Entidades;

import Entidades.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T01:51:09")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile SingularAttribute<Cargo, String> descripcion;
    public static volatile SingularAttribute<Cargo, BigDecimal> idcargo;
    public static volatile CollectionAttribute<Cargo, Usuario> usuarioCollection;

}