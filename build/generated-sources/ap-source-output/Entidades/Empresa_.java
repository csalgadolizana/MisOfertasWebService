package Entidades;

import Entidades.Estado;
import Entidades.Local;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-11-12T20:16:05")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> rut;
    public static volatile SingularAttribute<Empresa, String> descripcion;
    public static volatile CollectionAttribute<Empresa, Local> localCollection;
    public static volatile SingularAttribute<Empresa, Date> inicio;
    public static volatile SingularAttribute<Empresa, BigDecimal> idEmpresa;
    public static volatile SingularAttribute<Empresa, Estado> estadoIdEstado;
    public static volatile SingularAttribute<Empresa, String> nombre;
    public static volatile SingularAttribute<Empresa, Date> actualizacion;

}