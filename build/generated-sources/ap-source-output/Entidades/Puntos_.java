package Entidades;

import Entidades.CargarPuntos;
import Entidades.Cliente;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-20T01:52:55")
@StaticMetamodel(Puntos.class)
public class Puntos_ { 

    public static volatile SingularAttribute<Puntos, BigInteger> totalPuntos;
    public static volatile SingularAttribute<Puntos, BigInteger> puntosCanjeados;
    public static volatile SingularAttribute<Puntos, BigDecimal> idPuntos;
    public static volatile CollectionAttribute<Puntos, CargarPuntos> cargarPuntosCollection;
    public static volatile SingularAttribute<Puntos, Date> fechaActualizacion;
    public static volatile SingularAttribute<Puntos, Cliente> clienteIdCliente;

}