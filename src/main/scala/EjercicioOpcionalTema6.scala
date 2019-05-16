object EjercicioOpcionalTema6 {

    abstract class Transportes

    case class Coche(Empresa: String, Marca: String, Matricula:String, Kilometraje:Int, Combustible: String, precio: Double) extends Transportes
    case class Moto(Empresa: String, Marca: String, Matricula:String, precio: Double) extends Transportes
    case class Bus(Empresa: String, Marca: String,Matricula:String, NumPasajeros:Int, precio: Double) extends Transportes
    case class Tren(Linea: Int, NumVagones:Int, NumPasajeros:Int,precio: Double) extends Transportes
    case class Avion(Aerolinea: String, Origen: String, Destino: String, NumPasajeros:Int, Distancia: Int, precio: Double) extends Transportes
    case class Barco(Naviera: String, Cargamento: String, Origen: String, Destino: String, precio: Double) extends Transportes

    val vehiculoCoche = Coche("Transporting","Talbot","1234-AAA",1100, "Sin plomo 98", 1.81)
    val vehiculoBus = Bus("BusCamino","Jeep","1111_ZZZ",24,3.5)
    val vehiculoTren = Tren(5,3,120, 1.45)
    val vehiculoMoto = Moto("AlquiMoto","Yamaha","AA5151",1.09)
    val vehiculoAvion = Avion("Iberia","Madrid","Nueva York", 455,7500,325.0)

    def precioCoche(emp: String, marc: String, matr: String, km:Int, comb:String, precio:Double) {
      if(comb == "Diesel")
        println("Gasto Diesel en "+km+" kilómetros: "+ km*precio)
      else if (comb == "Sin plomo 95")
        println("Gasto Sin plomo 95 en "+km+" kilómetros: : "+ km*precio)
      else if (comb == "Sin plomo 98")
        println("Gasto Sin plomo 98 en "+km+" kilómetros: : "+ km*precio)
      else
        println("GASOLINA ESPECIAL")
    }

    def precioBus(emp: String, marc: String, matr: String, pasaj:Int,precio:Double) {
      if(marc == "Scania")
        println("Marca "+marc+"--> Precio del viaje: "+precio+". Número de pasajeros: "+pasaj+". Ganancias por trayecto: "+ pasaj*precio)
      else if (marc == "Saab")
        println("Marca "+marc+"--> Precio del viaje: "+precio+". Número de pasajeros: "+pasaj+". Ganancias por trayecto: "+ pasaj*precio)
      else if (marc == "Renault")
        println("Marca "+marc+"--> Precio del viaje: "+precio+". Número de pasajeros: "+pasaj+". Ganancias por trayecto: "+ pasaj*precio)
      else
        println("Otras marcas--> Precio del viaje: "+precio+". Número de pasajeros: "+pasaj+". Ganancias por trayecto: "+ pasaj*precio)
    }

    def precioTren(lin: Int, vagones: Int, pasaj: Int, precio:Double) {
      if(lin == 1)
        println("Precio línea "+lin+": "+precio)
      else if (lin == 2)
        println("Precio línea "+lin+": "+precio)
      else if (lin == 3)
        println("Precio línea "+lin+": "+precio)
      else
        println("Precio línea 4 y exteriores: "+precio)
    }

    def otherwise {
      println("No se puede calcular el precio del viaje...")
    }

    lazy val pCoche = precioCoche(vehiculoCoche.Empresa,vehiculoCoche.Marca,vehiculoCoche.Matricula, vehiculoCoche.Kilometraje, vehiculoCoche.Combustible, vehiculoCoche.precio)
    lazy val pBus = precioBus(vehiculoBus.Empresa, vehiculoBus.Marca,vehiculoBus.Matricula, vehiculoBus.NumPasajeros, vehiculoCoche.precio)
    lazy val pTren = precioTren(vehiculoTren.Linea, vehiculoTren.NumVagones,vehiculoTren.NumPasajeros, vehiculoCoche.precio)



    def consulta (x: Any): Unit = x match{
      case Coche(_, _, _, _, "Diesel", _) => pCoche
      case Coche(_, _, _, _, "Sin plomo 95", _) => pCoche
      case Coche(_, _, _, _, "Sin plomo 98", _) => pCoche
      case Coche(_, _, _, _, _, _) => pCoche
      case Bus(_, "Scania", _, _, _) => pBus
      case Bus(_, "Saab", _, _, _) => pBus
      case Bus(_, "Renault", _, _, _) => pBus
      case Bus(_, _, _, _, _) => pBus
      case Tren(1, _, _, _) => pTren
      case Tren(2, _, _, _) => pTren
      case Tren(3, _, _, _) => pTren
      case Tren(_, _, _, _) => pTren
      case _ => otherwise
    }

    consulta(vehiculoCoche)
    consulta(vehiculoBus)
    consulta(vehiculoAvion)
    consulta(vehiculoMoto)
    consulta(vehiculoTren)


}
