import java.io.File

// 제이슨 데이타 안에 삽입되는 내용은 농장안에 품목등 아무거나 적어도좋음

// "/farmRepository/farm/introduce/data/detail/farmDetail.json"

// 위 경로에 제이슨 생성


fun main(){
    farmDetail()

}


fun farmDetail(){

    var farmDetail = ""
    farmDetail += "{ \r\n"
    farmDetail += "\"가게이름\" : \"윤이나 농장\", \r\n"
    farmDetail += "\"파는 물건\" : \"농산물, 해산물\", \r\n"
    farmDetail += "\"배송여부\" : true \r\n"
    farmDetail += "}"


    File("farmRepository/farm/introduce/data/detail/farmDetail.json").parentFile.mkdirs()
    File("farmRepository/farm/introduce/data/detail/farmDetail.json").writeText(farmDetail)

}