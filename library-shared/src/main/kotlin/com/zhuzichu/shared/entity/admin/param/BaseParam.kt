package com.zhuzichu.shared.entity.admin.param

import org.hibernate.validator.HibernateValidator
import javax.validation.ConstraintViolationException
import javax.validation.Validation


interface  BaseParam {

    companion object {
        private val validator = Validation.byProvider(HibernateValidator::class.java).configure().failFast(true)
            .buildValidatorFactory().validator
    }

    fun formatCheck() {
        val validate = validator.validate(this)
        if (validate.size > 0) {
            throw ConstraintViolationException(validate)
        }
    }

}