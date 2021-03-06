object Ejercicio3 extends App {
  abstract class Informacion

  case class Nombre (n: String, apellidos: String ) extends Informacion

  case class Datos (telefono: Int, calle: String) extends Informacion

  val nom = Nombre("Patricia", "Criollo")
  val dat = Datos (638547891, "Calle Cartagena")

  def obtenerNombre(n: String, a: String): Unit ={
    if(a == "Criollo")
      println("Mi nombre es "+ n + ". Y mi apellido es "+ a)
  }

  def obtenerTelefono(t: Int, c: String): Unit ={
    if(c == "Mayor")
      println("Mi telefono es "+ t + ". Vivo en la calle " + c)
  }

  lazy val pNombre = obtenerNombre(nom.n, nom.apellidos)
  lazy val pDatos = obtenerTelefono(dat.telefono, dat.calle)

  def consulta (x: Any): Unit = x match {
    case Nombre(_, "Criollo") => pNombre
    case Datos(_, "Calle Cartagena") => pDatos
  }

    consulta(nom)
    println()
    consulta(dat)

}
