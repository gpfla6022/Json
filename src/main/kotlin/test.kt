import java.io.File

fun main(){
    //testWriteFile();
    // testWriteFile2();
    //testWriteFile3();
    testReadFile();
}

data class testArticle(
    val id:Int,
    val title: String,
    val body: String
) {
    fun toJson(): String {
        var jsonStr = ""

        jsonStr += "{"
        jsonStr += "\n"

        jsonStr += "\t" + """ "id":1, """.trim()

        jsonStr += "\n"

        jsonStr += "\t" + """ "title":"$title", """.trim()

        jsonStr += "\n"

        jsonStr += "\t" + """ "body":"$body" """.trim()

        jsonStr += "\n"

        jsonStr += "}"


        return jsonStr

    }
}

fun testReadFile(){
    testWriteFile()


    val fileContent = File("test/1.text").readText(Charsets.UTF_8)

    print("test/1.text의 내용 : $fileContent")
}









fun testWriteFile3(){

    val testArticle = testArticle(1, "제목1", "내용1")

    File("test/3.json").writeText(testArticle.toJson())
}

fun testWriteFile2(){
    val id = 1
    val title = "안녕하세요, 저는, age = 33"
    val body = "내용"

    var fileContent = ""
    fileContent += "{"
    fileContent += "\n"
    fileContent +=  "\t" + """ "id":$id, """.trim()
    fileContent += "\n"
    fileContent += "\t" + """ "title":$title, """.trim()
    fileContent += "\n"
    fileContent += "\t" + """ "body":$body """.trim()
    fileContent += "\n"
    fileContent += "}"

    File("test/1.text").writeText(fileContent)
}

fun testWriteFile() {
    File("test/1.text").writeText("안녕하세요.")
}