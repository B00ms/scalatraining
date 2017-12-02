import scala.annotation.tailrec
import scala.util.Random

object ExerciseChapter6 {

  def randomString(length: Int, inputSeq: Seq[Char]): String ={

    @tailrec
    def randomize(i: Int, stringAccumulator: String, inputSeq: Seq[Char]): String =
      if(i==0) return stringAccumulator;
      else return randomize(i - 1, stringAccumulator + inputSeq(Random.nextInt(inputSeq.length)), inputSeq);

    return randomize(length, "", inputSeq)
  }

  def randomCurried(inputSeq: Seq[Char]) = randomString(5, inputSeq)
}
