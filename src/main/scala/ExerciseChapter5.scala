object ExerciseChapter5 {

	implicit class Duplicator(val myThing: Any) {

		private def duplicateNumber(x: Number): Number = {
			myThing match {
				case b: Byte => b*2
				case d: Double => d*2
				case f: Float => f*2
				case i: Integer => i*2
				case l: Long => l*2
				case s: Short => s*2
			}
		}

		private def duplicateString(x: String): Any = {
			myThing.toString concat(myThing.toString)
		}

		private def duplicateAny(x: Any): List[Any] = {
			return List(myThing, myThing)
		}

		/***
		  * Generic access so we can duplicate anything we want
		  * @return myThing duplicated as specified by assignment chapter 5
		  */
		def duplicate(): Any ={
			myThing match {
				case x: Number => duplicateNumber(x)
				case x: String => duplicateString(x)
				case _ => duplicateAny(myThing)
			}
		}
	}
}
