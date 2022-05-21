import cn.hutool.core.util.IdUtil
import org.junit.jupiter.api.Test

class SnowflakeTest {

    @Test
    fun nextId(){
        val nextId = IdUtil.getSnowflake().nextId()
        println(nextId);
    }

}