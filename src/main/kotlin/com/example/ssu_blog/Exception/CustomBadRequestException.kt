package com.example.ssu_blog.Exception

class CustomBadRequestException(badRequestCode: BadRequestCode): RuntimeException() {
    public val badRequestCode: BadRequestCode = badRequestCode
}