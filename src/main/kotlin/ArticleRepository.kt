class ArticleRepository {

    var lastId = 0
    val articles = mutableListOf<Article>()

    fun addArticle(memberId: Int, boardIndex: Int, title: String, body: String): Int {
        val id = ++lastId
        val regDate = Util.getNowDateStr()
        val updateDate = Util.getNowDateStr()

        articles.add(Article(id, title, body, regDate, updateDate, memberId, boardIndex))

        return id
    }

    fun getArticleById(id: Int): Article? {
        for(article in articles){
            if(article.id == id){
                return article
            }
        }
        return null
    }

    fun delArticle(article: Article) {
        articles.remove(article)
    }

    fun filteredArticle(boardCode: String, searchKeyword: String, page: Int, itemsInAPage: Int): List<Article> {

        val filtered1Article = getStrArticle(articles, boardCode, searchKeyword)
        val filtered2Article = getIntArticle(filtered1Article, page, itemsInAPage)

        return filtered2Article
    }

    private fun getIntArticle(filtered1Article: List<Article>, page: Int, itemsInAPage: Int): List<Article> {
        val filteredArticle = mutableListOf<Article>()

        val offsetCount = (page - 1) * itemsInAPage
        val startIndex = filtered1Article.lastIndex - offsetCount
        var endIndex = startIndex - (itemsInAPage - 1)

        if(endIndex < 0){
            endIndex = 0
        }

        for(i in startIndex downTo endIndex){
            filteredArticle.add(filtered1Article[1])
        }
        return filteredArticle

    }

    private fun getStrArticle(articles: List<Article>, boardCode: String, searchKeyword: String): List<Article> {
        val filteredArticle = mutableListOf<Article>()

        if(boardCode.isNotEmpty() && searchKeyword.isNotEmpty()){
            return articles
        }

        val boardId = if(boardCode.isEmpty()){
            0
        }else{
            boardRepository.getBoardByBoardCode(boardCode)!!.boardIndex
        }

        for(article in articles){
            if(boardId != 0){
                if(article.boardIndex != boardId){
                    continue
                }
            }
            if(searchKeyword.isEmpty()){
                if(!article.title.contains(searchKeyword)){
                }
            }
            filteredArticle.add(article)
        }
        return filteredArticle

    }

    fun testArticle(){
        for(i in 1..100){
            addArticle(i%10+1, i%2+1, "제목$i","내용$i")
        }
    }


}