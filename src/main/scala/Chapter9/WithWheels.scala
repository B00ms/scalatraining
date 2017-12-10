package Chapter9

trait WithWheels {

  private var breaksOn = true;
  def toggleBreaks() : Unit ={
    if(breaksOn)
      breaksOn = false
    else
      breaksOn = true

    println("Break status: " + breaksOn)
  }
}
