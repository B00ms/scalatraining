package Chapter8

case class Circle(val diameter: Double) extends GeometricObject {
  val circumference: Double = Math.PI * diameter
  override val area: Double = Math.pow(circumference,2)*(4/Math.PI)

}
