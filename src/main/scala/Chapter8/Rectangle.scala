package Chapter8

case class Rectangle(width: Double, length: Double) extends GeometricObject {
  override val area: Double = width*length
}

