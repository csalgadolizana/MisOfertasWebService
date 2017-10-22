package Entidades;

import Entidades.Cliente;
import Entidades.Oferta;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-22T15:20:42")
@StaticMetamodel(Ofertavisi.class)
public class Ofertavisi_ { 

    public static volatile SingularAttribute<Ofertavisi, Date> fechaVisita;
    public static volatile SingularAttribute<Ofertavisi, BigDecimal> idofertav;
    public static volatile SingularAttribute<Ofertavisi, Cliente> clienteIdCliente;
    public static volatile SingularAttribute<Ofertavisi, Oferta> ofertaIdOferta;

}