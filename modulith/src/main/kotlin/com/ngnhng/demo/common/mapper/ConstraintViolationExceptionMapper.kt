package com.ngnhng.demo.common.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.validation.ConstraintViolationException
import jakarta.ws.rs.core.Context
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.core.UriInfo
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class ConstraintViolationExceptionMapper(
    @Context private val uriInfo: UriInfo, private val objectMapper: ObjectMapper
) : ExceptionMapper<ConstraintViolationException> {

    override fun toResponse(exception: ConstraintViolationException?): Response {
        val constraintViolations = exception?.constraintViolations

        val jsonObject = mutableMapOf<String, Any?>(
            "resource" to uriInfo.absolutePath?.path,
            "title" to "Validation Errors"
        )

        val errors = constraintViolations?.map { constraint ->
            mapOf(
                "field" to constraint.propertyPath.toString().split(".")[2],
                "violationMessage" to constraint.message
            )
        } ?: emptyList()

        jsonObject["errors"] = errors

        val jsonString = objectMapper.writeValueAsString(jsonObject)

        return Response.status(Response.Status.BAD_REQUEST).entity(jsonString).build()
    }
}