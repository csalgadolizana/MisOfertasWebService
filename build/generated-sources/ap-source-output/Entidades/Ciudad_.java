package Entidades;

import Entidades.Cliente;
import Entidades.Local;
import Entidades.Region;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T01:51:09")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, String> descripcion;
    public static volatile CollectionAttribute<Ciudad, Local> localCollection;
    public static volatile SingularAttribute<Ciudad, String> nombre;
    public static volatile SingularAttribute<Ciudad, BigDecimal> idCiudad;
    public static volatile SingularAttribute<Ciudad, Region> regionIdRegion;
    public static volatile CollectionAttribute<Ciudad, Cliente> clienteCollection;

}