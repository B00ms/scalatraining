import ExerciseChapter5._

object Main {

	def main(args: Array[String]): Unit = {
//		runExercise4()
//		runExercise5()
		runExercise6()
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

	}
}
