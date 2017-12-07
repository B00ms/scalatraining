package Chapter8

case class Triangle(val base: Double, val height: Double) extends GeometricObject{
  override val area: Double = (1d/2d)*base*height
}
