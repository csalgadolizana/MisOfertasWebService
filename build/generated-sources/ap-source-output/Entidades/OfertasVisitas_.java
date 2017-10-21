package Entidades;

import Entidades.Cliente;
import Entidades.Oferta;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-21T15:23:50")
@StaticMetamodel(OfertasVisitas.class)
public class OfertasVisitas_ { 

    public static volatile SingularAttribute<OfertasVisitas, BigDecimal> idOfertasVisitas;
    public static volatile SingularAttribute<OfertasVisitas, Date> fechaVisita;
    public static volatile SingularAttribute<OfertasVisitas, Cliente> clienteIdCliente;
    public static volatile SingularAttribute<OfertasVisitas, Oferta> ofertaIdOferta;

}