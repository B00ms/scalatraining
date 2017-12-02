import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex

object ExerciseChapter4 {

	private val httpsRegex: Regex = """(https://.+)""".r
	private val domainRegex: Regex = """(?:[^https://])(?:[^www\.])([\w\.-]*)([\.][a-zA-Z]+)""".r

	/**
	  * Implmented without patterns because I read the wrong Chapter 4 :P
	  * @param urls
	  */
	def runExercise(urls: List[String]): Unit = {
		//Seperates the input list into two lists
		val (safeDomain, unsafeDomain) = urls.partition(x => !httpsRegex.findAllIn(x).isEmpty)

		println("input: ")
		urls.foreach(println)

		println()

		println("Safe domains: ")
		getDomainNames(safeDomain).foreach(println)

		println()

		println("Unsafe domains: ")
		getDomainNames(unsafeDomain).foreach(println)
	}

	def getDomainNames(urls: List[String]): List[String] ={
		val domainNames = urls
				.map(x => domainRegex.findFirstMatchIn(x))
				.map(x => x.get.toString())
				.map(x => if(x.charAt(0).equals('.')) x.substring(1) else x)

		return domainNames
	}

	/**
	  * Same exercise using patterns
	  * @param urls
	  * @return
	  */
	def patternMatch(urls: List[String]): List[String] = {
		var safeDomains = new ListBuffer[String]
		var unsafeDomains = new ListBuffer[String]

		for (url <- urls) {
			 url match {
				case httpsRegex(https) =>
					safeDomains += url
				case entry =>
					unsafeDomains += url
			}
		}

		val safeDomainList = safeDomains
				.map(x => domainRegex.findFirstMatchIn(x))
				.map(x => x.get.toString())
				.map(x => if(x.charAt(0).equals('.')) x.substring(1) else x).toList

		val unsafeDomainList = unsafeDomains
				.map(x => domainRegex.findFirstMatchIn(x))
				.map(x => x.get.toString())
				.map(x => if(x.charAt(0).equals('.')) x.substring(1) else x).toList

		println("Safe domains")
		safeDomainList.foreach(println)

		println("")

		println("Unsafe domains")
		unsafeDomainList.foreach(println)

		return safeDomainList
	}

	/**
	  * From Programming scala 2nd edition
	  */
	def MatchOnRegularExpression(): Unit ={
		val BookExtractorRE = """Book: title=([^,]+),\s+author=(.+)""".r
		val MagazineExtractorRE = """Magazine: title=([^,]+),\s+issue=(.+)""".r

		val catalog = Seq(
			"Book: title=Programming Scala Second Edition, author=Dean Wampler",
			"Magazine: title=The New Yorker, issue=January 2014",
			"Unknown: text=Who put this here??"
		)

		for(item <- catalog){
			item match {
				case BookExtractorRE(title, author) => println(s"""Book: "$title", written by $author""")
				case MagazineExtractorRE(title, issue) => println(s"""Magazine: "$title", issue $issue""")
				case entry => println(s"Unrecongnized entry: $entry")
			}
		}
	}
}
