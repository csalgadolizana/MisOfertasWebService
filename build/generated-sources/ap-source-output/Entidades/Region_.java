package Entidades;

import Entidades.Ciudad;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T01:51:09")
@StaticMetamodel(Region.class)
public class Region_ { 

    public static volatile CollectionAttribute<Region, Ciudad> ciudadCollection;
    public static volatile SingularAttribute<Region, Long> idRegion;
    public static volatile SingularAttribute<Region, String> nombre;

}