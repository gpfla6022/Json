class MemberController {
    fun join() {

        print("아이디: ")
        val memId = readLineTrim()
        print("비밀번호: ")

        //중복
        val isJoinableId = memberRepository.isJoinableId(memId)

        if(!isJoinableId){ //isJoinableId 가 null이 아니면, 즉 값이 존재한다면
            println("이미 존재하는 아이디 입니다.")
            return
        }

        val memPw = readLineTrim()
        print("이름: ")
        val memName = readLineTrim()
        print("별명: ")
        val memNick = readLineTrim()
        print("전화번호: ")
        val memPh = readLineTrim()
        print("이메일: ")
        val memEmail = readLineTrim()


        val memberIndex = memberRepository.addMember(memId, memPw, memName, memNick, memPh, memEmail)

        println("$memberIndex 번 회원님 환영합니다.")
    }

    fun login() {

        print("아이디: ")
        val userId = readLineTrim()

        val member = memberRepository.getMemberById(userId)

        if(member == null){
            println("존재하지 않는 아이디 입니다.")
            return
        }

        print("비밀번호: ")
        val userPw = readLineTrim()

        if(member.memPw != userPw){
            println("비밀번호가 틀렸습니다.")
            return
        }

        logonMember = member

        println("${member.memNick}님 환영합니다.")
    }

    fun logout() {
        logonMember = null

        println("로그아웃 되었습니다.")
    }
}