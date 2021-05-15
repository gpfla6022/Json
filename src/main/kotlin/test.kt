import java.io.File

fun main(){

    zooJson()
    zooHtml()

}


fun zooHtml(){

    var testZoo = ""

    testZoo += "<!DOCTYPE html>\r\n"
    testZoo += "<html> \r\n"
    testZoo += "<head> \r\n"
    testZoo += "\t <meta charset = \"UTF-8\"> \r\n"
    testZoo += "\t <title> 우리 동물원 </title>\r\n"
    testZoo += "</head> \r\n"
    testZoo += "<body>\r\n"
    testZoo += "\t <h1>우리 동물원</h1>\r\n"
    testZoo += "\t <div>사파리</div>\r\n"
    testZoo += "\t <div>아쿠아리움</div>\r\n"
    testZoo += "\t <div>아기동물</div>\r\n"
    testZoo += "</body> \r\n"
    testZoo += "</html> \r\n"





    //file함수의 메소드와 유사
    File("test").mkdirs()


    File("test/testZoo.html").writeText(testZoo)

}

fun zooJson() {

    var testZoo = ""

    testZoo += "{\r\n"
    testZoo += "\"우리 동물원 1번\": \"사파리\", \r\n"
    testZoo += "\t \"사파리 동물\": { \r\n"
    testZoo +=  "\t\t \"육식동물 1\" : \"사자\",\r\n"
    testZoo += "\t\t \"육식동물 2\" : \"호랑이\",\r\n"
    testZoo += "\t\t \"초식동물 1\" : \"기린\",\r\n"
    testZoo += "\t\t \"초식동물 2\" : \"코끼리\"\r\n"
    testZoo +=  "}, \r\n"
    testZoo += "\"우리 동물원 2번\": \"아쿠아리움\", \r\n"
    testZoo += "\t \"아쿠아리움 물고기\": {\r\n"
    testZoo += "\t\t \"열대어 1\" : \"구피\",\r\n"
    testZoo += "\t\t \"열대어 2\" : \"플래티\",\r\n"
    testZoo += "\t\t \"해수어 1\" : \"상어\",\r\n"
    testZoo += "\t\t \"해수어 2\" : \"돌고래\"\r\n"
    testZoo += "}, \r\n"
    testZoo += "\"우리 동물원 3번\": \"아기동물\", \r\n"
    testZoo += "\t \"사파이 아기동물\": {\r\n"
    testZoo += "\t\t \"사자\" : \"3개월\",\r\n"
    testZoo += "\t\t \"호랑이\" : \"8개월\"\r\n"
    testZoo += "}, \r\n"
    testZoo += "\"직원\" : [\"짱구\", \"철수\", \"맹구\", \"유리\", \"훈이\"], \r\n"
    testZoo += "\"월급\" : true, \r\n"
    testZoo += "\"연봉\" : 3000, \r\n"
    testZoo += "\"연봉 상승률\" : 2.5, \r\n"
    testZoo += "\"월 광관객  수\" : \"50000명\" \r\n"
    testZoo += "}"


    File("test/JSONDATA/testZoo2.json").parentFile.mkdirs()

    File("test/JSONDATA/testZoo2.json").writeText(testZoo)


}

