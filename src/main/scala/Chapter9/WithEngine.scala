package Chapter9

trait WithEngine {
  private var engineRunning: Boolean = false

  def isEngineRunning(): Boolean = {
  return engineRunning
 }

  def turnEngineOn(): Unit = {
    engineRunning = true
    println("Engine is on")
  }
  def turnEngineOff(): Unit = {
    engineRunning = false
    println("Engine is off")
  }

}
