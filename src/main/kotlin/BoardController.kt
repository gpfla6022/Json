class BoardController {
    fun add() {

        if(logonMember == null){
            println("로그인을 해주세요.")
            return
        }

        val memId = logonMember!!.id

        println("게시판 이름: ")
        val name = readLineTrim()

        val boardByName = boardRepository.getBoardByName(name)

        if(boardByName != null){
            println("중복된 게시판 이름입니다.")
            return
        }

        println("게시판 코드: ")
        val code = readLineTrim()

        val boardByCode = boardRepository.getBoardByCode(code)

        if(boardByCode != null){
            println("중복된 게시판 코드입니다.")
            return
        }

        val boardIndex = boardRepository.addboard(memId, name, code)

        println("$boardIndex 번 게시판이 작성되었습니다.")
    }

    fun delete(rq: Rq) {
        if(logonMember == null){
            println("로그인을 해주세요.")
            return
        }

        val id = rq.getIntParam("id", 0)

        if(id == 0){
            println("게시판 번호를 확인해 주세요.")
            return
        }

        val board = boardRepository.getBoardId(id)

        if(board == null){
            println("존재하지 않는 게시판 입니다.")
            return
        }

        if(board.memId != logonMember!!.id){
            println("권한이 없습니다.")
            return
        }

        boardRepository.delBoard(board)

        println("$id 번 게시판이 삭제되었습니다.")
    }

    fun modify(rq: Rq) {
        if(logonMember == null){
            println("로그인을 해주세요.")
            return
        }

        val id = rq.getIntParam("id", 0)

        if(id == 0){
            println("게시판 번호를 확인해주세요.")
            return
        }

        val board = boardRepository.getBoardId(id)

        if(board == null){
            println("존재하지 않는 게시판 입니다.")
            return
        }

        if(board.memId != logonMember!!.id){
            println("권한이 없습니다.")
            return
        }

        print("새 게시판 이름: ")
        board.name = readLineTrim()
        print("새 게시판 코드: ")
        board.code = readLineTrim()
        board.updateDate = Util.getNowDateStr()

        println("$id 번 게시판이 수정되었습니다.")

    }
    // /article/list?page=1
    fun list(rq: Rq) {
        if(logonMember == null){
            println("로인을 해주세요.")
            return
        }

        val page = rq.getIntParam("page", 0)

        if(page == 0){
            println("페이지 번호를 다시 입력해 주세요.")
            return
        }

        val boards = boardRepository.getBoard()

        print("번호  /  이름  /  코드")

        for(board in boards){
            println("${board.boardIndex}  /  ${board.name}  /  ${board.code}")
        }

    }
}