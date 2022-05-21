import cn.hutool.crypto.SecureUtil
import cn.hutool.jwt.JWTHeader
import cn.hutool.jwt.JWTUtil
import org.junit.jupiter.api.Test


class JwtTest {

    private val sha256:String = SecureUtil.sha256("zhuzichu")

    private val jwt:String = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEyMywiZXhwaXJlX3RpbWUiOjE2NTQ0MTc5Mjg2MDZ9.rug6xG6b-qk5iM4W-tySpZfglvJJzKWsvnUlZI4WZwM"

    @Test
    fun createToken(){
        val map: Map<String, Any> = object : HashMap<String, Any>() {
            init {
                put("uid", "123".toInt())
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15)
            }
        }
        println(JWTUtil.createToken(map,sha256.toByteArray()))
    }

    @Test
    fun verify(){
        println(JWTUtil.verify(jwt, sha256.toByteArray()))
    }

    @Test
    fun parseToken(){
        val jwt = JWTUtil.parseToken(jwt)
        val header = jwt.getHeader(JWTHeader.TYPE)
        val payload = jwt.getPayload("uid")
        println(payload)
    }

}