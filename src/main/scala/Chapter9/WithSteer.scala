package Chapter9

trait WithSteer {

  private var direction: String = ""

  def turnLeft(): Unit ={
    direction = "left"
    println("Steering " + direction)
  }

  def turnRight(): Unit ={
      direction = "right"
    println("Steering: " + direction)
  }
}
