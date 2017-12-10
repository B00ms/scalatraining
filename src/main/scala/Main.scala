import Chapter8.{Circle, GeometricObject, Rectangle, Triangle}
import Chapter9.{WithEngine, WithSteer, WithWheels}
import ExerciseChapter5._

import scala.util.Try

object Main {

	def main(args: Array[String]): Unit = {
//		runExercise4()
//		runExercise5()
//		runExercise6()
//    runExercise7()
//    runExercise8()
		runExercise9()
	}

	def runExercise4(): Unit =	{
		val urls = List(
		"wikipedia.org",
		"www.nos.nl",
		"http://www.scala-sbt.org/",
		"http://nederland.nl",
		"https://oracle.com/",
		"https://wikileaks.org,",
		"https://anchormen.nl",
		"https://www.mapr.com",
		"https://www.reddit.com")

		println("Without patterns: ")
		ExerciseChapter4.runExercise(urls)

		println("With patterns: ")
		ExerciseChapter4.patternMatch(urls)
	}


	def runExercise5(): Unit = {
		val s: Double = 1.5
		println("Number duplication input 1.5: ")
		println(s duplicate )
		println()

		println("String duplication input Anchormen: ")
		println("Anchormen" duplicate)
		println()

		println("Object duplication input empty Option: ")
		val someObject: Option[String] = Option.empty[String]
		val myList = someObject.duplicate().asInstanceOf[List[AnyRef]]
		println("Container class: " + myList.getClass.toGenericString)
		myList.foreach(println)
	}

	def runExercise6(): Unit  = {
    println("With tail recursion:")
		println(ExerciseChapter6.randomString(10, List('A', 'B','C')) );

    println("Same as before but now curried")
    print(ExerciseChapter6.randomCurried(List('A', 'B', 'C','D', 'E', 'G', 'H', 'I')))
	}

  def runExercise7(): Unit = {
    val inputList = List("1", "2", "x", "three", "3")

    print("Input sequence of Strings: ")
    inputList.foreach(x => println(isNumericString(x)))

    val output: Int = inputList.foldLeft(0) {
      (_ + isNumericString(_).getOrElse(0))
    }
    print(output)
  }

  def isNumericString(input: String): Try[Int] = {
    Try{Integer.valueOf(input)}

  }

  def runExercise8(): Unit = {
		val myList: List[GeometricObject] = {
			new Circle(5) :: new Circle(10) :: new Circle(15) ::
			new Rectangle(5, 7) :: new Rectangle(10, 14) :: new Rectangle(15, 21) ::
			new Triangle(5, 10) :: new Triangle(10, 15) :: new Triangle(15, 20):: Nil}

    println("Area of the geometric objects: ")
    myList.foreach(x => println(x.area))
    val areaSum = myList.foldLeft(0.0)(_ + _.area)
    println("Total area: " + areaSum)
  }

	def runExercise9(): Unit = {
		val myCar = new Object with WithWheels with WithSteer with WithEngine;
		myCar.turnEngineOn()
		myCar.toggleBreaks()
		myCar.turnLeft()
		myCar.turnRight()
		myCar.toggleBreaks()
		myCar.turnEngineOff()
	}
}
