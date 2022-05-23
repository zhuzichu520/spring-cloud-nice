package com.zhuzichu.system.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.zhuzichu.shared.entity.admin.po.Admin
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AdminMapper : BaseMapper<Admin> {

}