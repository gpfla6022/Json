class ArticleContoller {
    fun write() {
        if (logonMember == null) {
            println("로그인을 해주세요.")
            return
        }

        val memberId = logonMember!!.id

        val boards = boardRepository.getBoard()

        var boardSelectStr = ""

        for (board in boards) {
            if (boardSelectStr.isNotEmpty()){
                boardSelectStr += ", "
            }
            boardSelectStr += "${board.boardIndex} = ${board.name} "
        }

        println("$boardSelectStr")

        println("게시판을 고르세요(번호) : ")
        val boardIndex = readLineTrim().toInt()

        print("제목: ")
        val title = readLineTrim()
        print("내용: ")
        val body = readLineTrim()

        val article = articleRepository.addArticle(memberId, boardIndex, title, body)

        println("$article 번 게시물이 작성되었습니다.")
    }

    fun delete(rq: Rq) {
        if(logonMember == null){
            println("로그인을 해주세요.")
            return
        }

        val id = rq.getIntParam("id",0)

        if(id == 0){
            println("게시물 번호를 확인해 주세요.")
            return
        }

        val article = articleRepository.getArticleById(id)

        if(article == null){
            println("존재하지 않는 게시물 입니다.")
            return
        }

        if(article.memberId != logonMember!!.id){
            println("권한이 없습니다.")
            return
        }
        articleRepository.delArticle(article)

        println("$id 번 게시물이 삭제되었습니다.")

    }

    fun modify(rq: Rq) {
        if(logonMember == null){
            println("로그인을 해주세요.")
            return
        }

        val id = rq.getIntParam("id",0)

        if(id == 0){
            println("게시물 번호를 확인해 주세요.")
            return
        }

        val article = articleRepository.getArticleById(id)

        if(article == null){
            println("존재하지 않는 게시물 입니다.")
            return
        }

        if(article.memberId != logonMember!!.id){
            println("권한이 없습니다.")
            return
        }

        print("새 제목: ")
        article.title = readLineTrim()
        print("새 내용: ")
        article.body = readLineTrim()
        article.updateDate = readLineTrim()

        println("$id 번 게시물이 수정되었습니다.")

    }

    fun detail(rq: Rq) {
        if(logonMember == null){
            println("로그인을 해주세요.")
            return
        }

        val id = rq.getIntParam("id",0)

        if(id == 0){
            println("게시물 번호를 확인해 주세요.")
            return
        }

        val article = articleRepository.getArticleById(id)

        if(article == null){
            println("존재하지 않는 게시물 입니다.")
            return
        }

        if(article.memberId != logonMember!!.id){
            println("권한이 없습니다.")
            return
        }

        println("게시물의 번호: ${article.id}")
        println("$id 번 게시물의 번호: ${article.title}")
        println("$id 번 게시물의 번호: ${article.body}")
        println("$id 번 게시물의 번호: ${article.regDate}")
        println("$id 번 게시물의 번호: ${article.updateDate}")

    }

    fun list(rq: Rq) {
        if(logonMember == null){
            println("로그인을 해주세요.")
            return
        }

        val boardCode = rq.getStringParam("boardCode", "")
        val searchKeyword = rq.getStringParam("searchKeyword", "")
        val page = rq.getIntParam("page", 0)


        val filteredArticle = articleRepository.filteredArticle(boardCode, searchKeyword, page, 0)

        print("게시판 이름  /  번호  /  제목  /  작성자  /  갱신일")

        for(article in filteredArticle){

            val board = boardRepository.getBoardByBoardIndex(article.boardIndex)
            val boardName = board!!.name

            val writer = memberRepository.getMemberByMemberIndex(article.memberId)
            val writerName = writer!!.memNick

            println("$boardName  /  ${article.id}  /  ${article.title}  /  $writerName /  ${article.updateDate}")
        }

    }
}