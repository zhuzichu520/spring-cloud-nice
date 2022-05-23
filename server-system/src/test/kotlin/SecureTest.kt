import cn.hutool.crypto.SecureUtil
import org.junit.jupiter.api.Test

class SecureTest {

    private var text:String = "admin"

    @Test
    fun md5(){
        println(SecureUtil.md5(text))
    }
}