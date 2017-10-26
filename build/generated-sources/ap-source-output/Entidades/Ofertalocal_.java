package Entidades;

import Entidades.Local;
import Entidades.Oferta;
import Entidades.OfertalocalPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-26T17:21:35")
@StaticMetamodel(Ofertalocal.class)
public class Ofertalocal_ { 

    public static volatile SingularAttribute<Ofertalocal, String> descripcion;
    public static volatile SingularAttribute<Ofertalocal, OfertalocalPK> ofertalocalPK;
    public static volatile SingularAttribute<Ofertalocal, Oferta> oferta;
    public static volatile SingularAttribute<Ofertalocal, Local> local;

}