class MemberRepository {

    var lastId = 0
    val members = mutableListOf<Member>()

    fun addMember(memId: String, memPw: String, memName: String, memNick: String, memPh: String, memEmail: String): Int {
        val id = ++lastId
        val regDate = Util.getNowDateStr()
        val updateDate = Util.getNowDateStr()

        members.add(Member(id,memId, memPw, memName, memNick, memPh, memEmail, regDate, updateDate))

        return id
    }

    fun getMemberById(userId: String): Member? {
        for(member in members){
            if(member.memId == userId)
                return member
        }
        return null
    }

    fun isJoinableId(memId: String): Boolean {
        val member = getMemberById(memId)
        return member == null
    }

    fun getMemberByMemberIndex(memberId: Int): Member? {
        for(member in members){
            if(member.id == memberId){
                return member
            }
        }
        return null
    }

    fun testMember(){
        for(i in 1..10){
            addMember("user$i", "1", "1", "user$i","1", "1")
        }
    }
}