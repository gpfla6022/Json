import java.io.File

// 사용자에게 입력받고 그것을 파일에 저장하는 기능을 구현해 볼 것
// 입력받고 싶은 것 : 가게이름, 가게 위치, 배송여부



fun main(){


    print("가게 이름을 입력해 주세요: ")
    val storeName = readLine()!!.trim()
    print("가게 위치를 입력해 주세요: ")
    val location = readLine()!!.trim()
    print("배달 여부를 입력해 주세요: ")
    val delivery = readLine()!!.trim()  // Y/N 으로 입력받기


    farmDetail(storeName, location, delivery)

}


fun farmDetail(storeName: String, location: String, delivery: String){

    var farmDetail = ""

    farmDetail +="{ \r\n"
    farmDetail +="\t \"가게 이름\" : \"$storeName\", \r\n "
    farmDetail +="\t \"가게 위치\" : \"$location\", \r\n "
    farmDetail +="\t \"가게 여부\" : \"$delivery\" \r\n "
    farmDetail +="}"



    File("farmRepository/farm/introduce/data/detail/farmDetail.json").parentFile.mkdirs() // 폴더 만들기
    File("farmRepository/farm/introduce/data/detail/farmDetail2.json").writeText(farmDetail) // 파일 만들기

}
