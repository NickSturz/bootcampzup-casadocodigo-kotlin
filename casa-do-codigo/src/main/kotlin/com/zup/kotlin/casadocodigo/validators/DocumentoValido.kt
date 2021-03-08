package com.zup.cartaobrancokotlin.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = arrayOf(DocumentoValidator::class))
annotation class DocumentoValido(
    val message: String = "Esse documento não é valido",
    val groups: Array<KClass<Any>> =[],
    val payload: Array<KClass<Payload>> =[]
)
