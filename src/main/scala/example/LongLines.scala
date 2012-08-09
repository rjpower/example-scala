package example
import scala.io.Source

object LongLines {

  def processSource(source: Source, width: Int): String = {

    def processLine(line: String): String = {
      if (line.length > width) line.trim else ""
    }

    val result = for (line <- source.getLines()) yield processLine(line)
    result.mkString
  }

}