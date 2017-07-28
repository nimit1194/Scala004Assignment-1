import java.io.File
import org.scalatest.AsyncFunSuite

class ListOfFilesTest extends AsyncFunSuite {
  val listOfFiles = new ListOfFiles().getFiles("/home/knoldus/FrameWorkTutorail/scala4/src/test/TestFolder")

  val file1 = new File("/home/knoldus/FrameWorkTutorail/scala4/src/test/TestFolder/f1.txt")
  val file2 = new File("/home/knoldus/FrameWorkTutorail/scala4/src/test/TestFolder/D2/f3")
  val file3 = new File("/home/knoldus/FrameWorkTutorail/scala4/src/test/TestFolder/D2/f2")
  val file4 = new File("/home/knoldus/FrameWorkTutorail/scala4/src/test/TestFolder/D3/D4/f5")
  val file5 = new File("/home/knoldus/FrameWorkTutorail/scala4/src/test/TestFolder/D3/D4/f4")

  test("Testing for list of Files") {

    listOfFiles.map(files => assert(files == List(file1, file2, file3, file4, file5)))

  }
  test("Testing for non-existant file") {
    recoverToSucceededIf[NullPointerException] {
      new ListOfFiles().getFiles("invalid address")
    }
  }

}
