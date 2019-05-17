import scala.util.Random

object Ejercicio1 extends App {
  def comprobarNumero(numero: Int) ={
    numero match {
      case 0 | 1 | 2  => "Inicio"
      case 3 | 4 => "Medio"
      case 5 => "Final"
      case _ => "Error"
    }
  }

  override def main(args: Array[String]): Unit = {
    val x: Int = Random.nextInt(5)

    println(comprobarNumero(x))

  }
}
