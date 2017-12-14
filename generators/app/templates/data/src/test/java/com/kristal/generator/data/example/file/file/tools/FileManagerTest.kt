package <%= appPackage %>.data.example.file.file.tools

import <%= appPackage %>.data.ApplicationTestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

/**
 * Created by Dwi_Ari on 10/31/17.
 */
internal class FileManagerTest :ApplicationTestCase(){
    private lateinit var fileManager: FileManager

    @Before
    fun setup() {
        fileManager = FileManager()
    }

    @After
    fun tearDown() {
        fileManager.clearDirectory(cacheDir)
    }

    @Test
    fun testWriteToFile() {
        val fileToWrite = createDummyFile()
        val fileContent = "content"

        fileManager.writeToFile(fileToWrite, fileContent)

        assertThat(fileToWrite.exists()).isTrue()
    }

    @Test
    fun testReadFileContent() {
        val fileToWrite = createDummyFile()
        val fileContent = "content\n"

        fileManager.writeToFile(fileToWrite, fileContent)
        val expectedContent = fileManager.readFileContent(fileToWrite)

        assertThat(fileContent).isEqualTo(expectedContent)
    }

    private fun createDummyFile(): File {
        val dummyFilePath = cacheDir.path + File.separator + "dummyFile"
        return File(dummyFilePath)
    }
}