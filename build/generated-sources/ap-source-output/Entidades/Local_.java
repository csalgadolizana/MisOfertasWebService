package Entidades;

import Entidades.Ciudad;
import Entidades.Empresa;
import Entidades.Ofertalocal;
import Entidades.Reporte;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T18:16:52")
@StaticMetamodel(Local.class)
public class Local_ { 

    public static volatile SingularAttribute<Local, Empresa> empresaIdEmpresa;
    public static volatile SingularAttribute<Local, BigDecimal> idLocal;
    public static volatile SingularAttribute<Local, String> direccion;
    public static volatile SingularAttribute<Local, Ciudad> ciudadIdCiudad;
    public static volatile CollectionAttribute<Local, Reporte> reporteCollection;
    public static volatile CollectionAttribute<Local, Ofertalocal> ofertalocalCollection;
    public static volatile SingularAttribute<Local, String> nombre;

}