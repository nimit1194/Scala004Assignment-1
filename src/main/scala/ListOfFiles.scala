import java.io.File
import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/** An application which takes folder path as input
  * and return all the names of files in a directory
  * using Scala futures.
  */

class ListOfFiles {
  def getFiles (dir: String): Future[List[File]] = {

    Future {

      val fileObject = new File(dir)

      @tailrec
      def getAllFiles (dir: List[File], file: List[File]): List[File] = {
        if (dir.isEmpty) {
          file
        }
        else {


          val listOfFiles = dir.head.listFiles().toList
          val listOfDir = dir.tail ::: listOfFiles.filter(_.isDirectory)
          val listOfAllFiles = file ::: listOfFiles.filter(_.isFile)

          getAllFiles(listOfDir, listOfAllFiles)
        }
      }

      val fileList = List(fileObject)
      getAllFiles(fileList, List())
    }

  }
}

