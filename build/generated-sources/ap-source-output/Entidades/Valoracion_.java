package Entidades;

import Entidades.Categoria;
import Entidades.Cliente;
import Entidades.Oferta;
import Entidades.ValoracionPK;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-10-20T23:50:31")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ { 

    public static volatile SingularAttribute<Valoracion, Cliente> cliente;
    public static volatile SingularAttribute<Valoracion, ValoracionPK> valoracionPK;
    public static volatile SingularAttribute<Valoracion, Categoria> categoriaIdCategoria;
    public static volatile SingularAttribute<Valoracion, String> boletaAdjunta;
    public static volatile SingularAttribute<Valoracion, Oferta> oferta;
    public static volatile SingularAttribute<Valoracion, Date> fechavaloracion;
    public static volatile SingularAttribute<Valoracion, BigInteger> nota;

}