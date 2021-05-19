class BoardRepository {

    var lastId = 0
    val boards = mutableListOf<Board>()

    fun addboard(memId: Int, name: String, code: String): Int {
        val boardIndex = ++lastId
        val regDAte = Util.getNowDateStr()
        val updateDate = Util.getNowDateStr()

        boards.add(Board(boardIndex, memId, name, code, regDAte, updateDate))

        return boardIndex
    }

    fun getBoardByName(name: String): Board? {
        for (board in boards) {
            if (board.name == name) {
                return board
            }
        }
        return null
    }

    fun getBoardByCode(code: String): Board? {
        for (board in boards) {
            if (board.code == code) {
                return board
            }
        }
        return null
    }

    fun getBoardId(id: Int): Board? {
        for (board in boards) {
            if (board.boardIndex == id) {
                return board
            }
        }
        return null
    }

    fun delBoard(board: Board) {
        boards.remove(board)
    }

    fun getBoard(): List<Board> {
        return boards
    }

    fun getBoardByBoardCode(boardCode: String): Board? {
        for (board in boards) {
            if (board.code == boardCode) {
                return board
            }
        }
        return null
    }

    fun getBoardByBoardIndex(boardIndex: Int): Board? {
        for(board in boards){
            if(board.boardIndex == boardIndex){
                return board
            }
        }
        return null
    }

    fun testBoard(){
        addboard(1, "공지", "notice")
        addboard(2, "자유", "free")
    }

}