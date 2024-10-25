package com.java.game.infra.security.jwt

import org.springframework.security.authentication.AbstractAuthenticationToken
import java.io.Serializable


class JwtAuthenticationToken<WebAuthenticationDetails>(
    private val principal: UserPrincipal,
    detail : WebAuthenticationDetails,
): AbstractAuthenticationToken(principal.authorities), Serializable {

    init {
        super.setAuthenticated(true)
        super.setDetails(detail)
    }

    override fun getCredentials()=null


    override fun getPrincipal() = principal

    override fun isAuthenticated(): Boolean {
        return true
    }

}