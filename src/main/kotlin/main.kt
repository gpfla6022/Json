val memberRepository = MemberRepository()
val boardRepository = BoardRepository()
val articleRepository = ArticleRepository()
var logonMember: Member? = null


fun main(){

    println("== SIMPLE SSG START ==")

    memberRepository.testMember()
    boardRepository.testBoard()
    articleRepository.testArticle()

    while(true){

        val systemController = SystemController()
        val memberController = MemberController()
        val boardController = BoardController()
        val articleController = ArticleContoller()


        val prompt = if(logonMember == null){
            "명령어) "
        }else{
            logonMember!!.memNick
        }

        print(prompt)
        val command = readLineTrim()

        val rq = Rq(command)

        when(rq.actionPath){
            "/system/exit()" -> {
                systemController.exit()
                break
            }
            "/member/join" -> {
                memberController.join()
            }
            "/member/login" -> {
                memberController.login()
            }
            "/member/logout" -> {
                memberController.logout()
            }
            "/board/add" -> {
                boardController.add()
            }
            "/board/delete" -> {
                boardController.delete(rq)
            }
            "/board/modify" -> {
                boardController.modify(rq)
            }
            "/board/list" -> {
                boardController.list(rq)
            }
            "/article/write" -> {
                articleController.write()
            }
            "/article/delete" ->{
                articleController.delete(rq)
            }
            "/article/modify" -> {
                articleController.modify(rq)
            }
            "/article/detail" -> {
                articleController.detail(rq)
            }
            "/article/list" -> {
                articleController.list(rq)
            }

            else -> {
                println("존재하지 않는 명령어 입니다.")
            }
        }
    }
    println("== SIMPLE SSG END ==")

}
