package com.zhuzichu.admin.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.zhuzichu.shared.entity.admin.po.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User> {

}