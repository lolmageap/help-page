package com.cherhy.helppage

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelpPageApi(
    private val helpPage: HelpPage,
) {
    @PostMapping("/help/{uuid}")
    fun helpPage(
        @PathVariable uuid: String,
    ) {
        require(uuid == Randomizer.uuid) { "Invalid UUID" }
        val email = helpPage.contact.email
        TODO("여기서 email을 보내는 로직을 작성해야함.")
        /**
         * 실제로 이메일을 보내는게 아닌 내가 만든 특정 수신 서버에서 api 호출을 받고 그 수신 서버에서 이메일을 보내는 로직을 작성해야함.
         * 서버가 init 될 때 uuid를 생성하고 내 수신 서버에서는 이 uuid 값을 보낸 사용자만 허용하자.
         * application이 꺼진다면 uuid 삭제 call api를 만들어서 수신 서버에서 삭제하자.
         */
    }
}

object Randomizer {
    const val UUID = "uuid"
    val uuid: String = java.util.UUID.randomUUID().toString()
}